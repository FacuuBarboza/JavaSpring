package com.informatorio.info_spring.mapper.usuario;

import com.informatorio.info_spring.dto.usuario.UsuarioCreateDto;
import com.informatorio.info_spring.dto.usuario.UsuarioDto;
import com.informatorio.info_spring.mapper.perfil.PerfilMapper;
import com.informatorio.info_spring.model.Usuario;

import java.util.List;

public final class UsuarioMapper {

    private UsuarioMapper() {
        // Constructor privado para evitar la instanciación
    }

    public static UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setPerfilUsuarioDto(PerfilMapper.toDto(usuario.getPerfil()));
        return usuarioDto;

    }

    public static List<UsuarioDto> toDtoList(List<Usuario> usuarios) {
        if (usuarios == null) return null;

        return usuarios.stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }

    public static Usuario toEntity(UsuarioCreateDto usuarioCreateDto) {
        if (usuarioCreateDto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioCreateDto.getNombre());
        usuario.setEmail(usuarioCreateDto.getEmail());
        usuario.setPerfil(PerfilMapper.toEntity(usuarioCreateDto.getPerfilUsuarioDto()));
        usuario.setEntradasDiarias(List.of());
        return usuario;
    }
}
