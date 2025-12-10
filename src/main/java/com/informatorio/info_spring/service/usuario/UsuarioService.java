package com.informatorio.info_spring.service.usuario;

import com.informatorio.info_spring.dto.perfil.PerfilUsuarioDto;
import com.informatorio.info_spring.dto.usuario.UsuarioCreateDto;
import com.informatorio.info_spring.dto.usuario.UsuarioDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {

    List<UsuarioDto> findAll(String nombre, String email, String colorFavorito);
    UsuarioDto crearUsuario(UsuarioCreateDto usuarioCreateDto);
    Optional<UsuarioDto> obtenerPorId(UUID id);
    PerfilUsuarioDto updatePerfil(UUID id, PerfilUsuarioDto perfilUsuarioDto);

    UsuarioDto updateUsuario(UUID id, UsuarioCreateDto usuarioCreateDto);

    boolean eliminarUsuario(UUID id);

    //UsuarioDto updateUsuario()
}
