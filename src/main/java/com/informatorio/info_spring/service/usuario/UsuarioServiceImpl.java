package com.informatorio.info_spring.service.usuario;

import com.informatorio.info_spring.dto.perfil.PerfilUsuarioDto;
import com.informatorio.info_spring.dto.usuario.UsuarioCreateDto;
import com.informatorio.info_spring.dto.usuario.UsuarioDto;
import com.informatorio.info_spring.exception.ResourceNotFoundException;
import com.informatorio.info_spring.mapper.perfil.PerfilMapper;
import com.informatorio.info_spring.mapper.usuario.UsuarioMapper;
import com.informatorio.info_spring.model.PerfilUsuario;
import com.informatorio.info_spring.model.Usuario;
import com.informatorio.info_spring.repository.specification.UsuarioSpecifications;
import com.informatorio.info_spring.repository.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDto> findAll(String nombre, String email, String colorFavorito) {
        // Lógica para obtener todos los usuarios
        Specification<Usuario> spec = Specification.unrestricted();

        if ( nombre != null && !nombre.isBlank()){
            spec = spec.and(UsuarioSpecifications.byNombre(nombre));
        }

        if ( email != null && !email.isBlank()){
            spec = spec.and(UsuarioSpecifications.byEmail(email));
        }

        if (colorFavorito != null && !colorFavorito.isBlank()) {
            spec = spec.and(UsuarioSpecifications.byColorFavorito(colorFavorito));
        }

        List<Usuario> usuarioList = usuarioRepository.findAll(spec);

        return UsuarioMapper.toDtoList(usuarioList);

    }

    @Override
    public UsuarioDto crearUsuario(UsuarioCreateDto usuarioCreateDto) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioCreateDto);
        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toDto(usuario);
    }

    @Override
    public Optional <UsuarioDto> obtenerPorId(UUID id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario usuarioEntity = usuario.get();
            return Optional.of( UsuarioMapper.toDto(usuarioEntity) );
        }
        return Optional.empty();
    }

    @Override
    public UsuarioDto updateUsuario(UUID id, UsuarioCreateDto usuarioCreateDto) {
        //1. Buscar el usuario por ID
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Optional<Usuario> usuarioExist = usuarioRepository.findByEmail(usuarioCreateDto.getEmail());

            if (usuarioExist.isPresent() && !usuarioExist.get().getId().equals(id)) {
                throw new IllegalArgumentException("El email ya está en uso por otro usuario.");
            }

            //2. Setear campo a campo para actualizarlo
            Usuario usuarioEntity = usuario.get();
            usuarioEntity.setNombre(usuarioCreateDto.getNombre());
            usuarioEntity.setEmail(usuarioCreateDto.getEmail());

            PerfilUsuario perfilUsuario = usuarioEntity.getPerfil();
            //3. Chequear si no tiene perfil: crearlo, sino actualizarlo

            if (perfilUsuario == null) {
                perfilUsuario = PerfilMapper.toEntity(usuarioCreateDto.getPerfilUsuarioDto());
                usuarioEntity.setPerfil(perfilUsuario);
            } else {
                perfilUsuario.setBio(usuarioCreateDto.getPerfilUsuarioDto().getBiografia());
                perfilUsuario.setColorFavorito(usuarioCreateDto.getPerfilUsuarioDto().getColorFavorito());
                perfilUsuario.setFraseDelDia(usuarioCreateDto.getPerfilUsuarioDto().getFraseDelDia());
            }

            //4. Guardar el usuario actualizado
            Usuario usuarioActualizado = usuarioRepository.save(usuarioEntity);

            //5. devolver el usuarioDto
            return UsuarioMapper.toDto(usuarioActualizado);
        }

        return null;

    }

    @Override
    public boolean eliminarUsuario(UUID id) {

        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public PerfilUsuarioDto updatePerfil(UUID id, PerfilUsuarioDto perfilUsuarioDto) {
        log.info("Actualizando el perfil del usuario con ID: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));

        if (usuario.getPerfil() == null) {
            PerfilUsuario nuevoPerfil = PerfilMapper.toEntity(perfilUsuarioDto);
            usuario.setPerfil(nuevoPerfil);
        } else {
            PerfilMapper.updateEntity(usuario.getPerfil(), perfilUsuarioDto);
        }

        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        log.info("Perfil del usuario con ID: {} actualizado exitosamente", id);
        return PerfilMapper.toDto(usuarioActualizado.getPerfil());
    }
}
