package com.informatorio.info_spring.dto.usuario;

import com.informatorio.info_spring.dto.perfil.PerfilUsuarioDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @Valid
    private PerfilUsuarioDto perfilUsuarioDto;
    //Entre otros



}