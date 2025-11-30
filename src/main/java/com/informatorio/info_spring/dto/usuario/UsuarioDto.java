package com.informatorio.info_spring.dto.usuario;

import com.informatorio.info_spring.dto.perfil.PerfilUsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private UUID id;
    private String nombre;
    private String email;
    private PerfilUsuarioDto perfilUsuarioDto;
    //Entre otros



}
