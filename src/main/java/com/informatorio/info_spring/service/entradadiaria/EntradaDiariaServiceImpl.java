package com.informatorio.info_spring.service.entradadiaria;

import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaCreateDto;
import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaDto;
import com.informatorio.info_spring.mapper.entradadiaria.EntradaDiariaMapper;
import com.informatorio.info_spring.model.EntradaDiaria;
import com.informatorio.info_spring.model.Habito;
import com.informatorio.info_spring.model.Usuario;
import com.informatorio.info_spring.repository.entradadiaria.EntradaDiariaRepository;
import com.informatorio.info_spring.repository.habito.HabitoRepository;
import com.informatorio.info_spring.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntradaDiariaServiceImpl implements EntradaDiariaService {

    private final EntradaDiariaRepository entradaDiariaRepository;
    private final UsuarioRepository usuarioRepository;
    private final HabitoRepository habitoRepository;

    @Override
    public EntradaDiariaDto create(EntradaDiariaCreateDto createDto) {
        UUID uuidUsuario = createDto.getUsuarioId();

        Optional<Usuario> usuario = usuarioRepository.findById(uuidUsuario);

        if(usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado id: " + uuidUsuario);
        }

        List<Habito> habitos = List.of();
        if (createDto.getHabitosIds() !=null && !createDto.getHabitosIds().isEmpty()) {
            habitos = habitoRepository.findAllById( createDto.getHabitosIds() );
            if( habitos.size() != createDto.getHabitosIds().size() ) {
                throw new IllegalArgumentException("Algunos de los habitos no se ha encontrado");
            }
        }

        EntradaDiaria entradaDiaria = new EntradaDiaria();
        entradaDiaria.setUsuario(usuario.get());
        entradaDiaria.setHabitos(habitos);
        entradaDiaria.setFecha(createDto.getFecha());
        entradaDiaria.setEmocion(createDto.getEmocion());
        entradaDiaria.setReflexion(createDto.getReflexion());

        EntradaDiaria saved = entradaDiariaRepository.save(entradaDiaria);

        return EntradaDiariaMapper.toDto(saved);


    }

}
