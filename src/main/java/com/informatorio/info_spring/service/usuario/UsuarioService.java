package com.informatorio.info_spring.service.usuario;

import com.informatorio.info_spring.dto.usuario.UsuarioCreateDto;
import com.informatorio.info_spring.dto.usuario.UsuarioDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {

    List<UsuarioDto> findAll();
    UsuarioDto crearUsuario(UsuarioCreateDto usuarioCreateDto);
    Optional<UsuarioDto> obtenerPorId(UUID id);

    UsuarioDto updateUsuario(UUID id, UsuarioCreateDto usuarioCreateDto);

    boolean eliminarUsuario(UUID id);

    //UsuarioDto updateUsuario()
}
