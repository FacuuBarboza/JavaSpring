package com.informatorio.info_spring.dto.perfil;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioDto {

    private Long id;

    @NotBlank(message = "La biografía no puede estar vacía")
    private String biografia;

    @NotBlank(message = "El color favorito no puede estar vacío")
    private String colorFavorito;

    @NotBlank(message = "La frase del día no puede estar vacía")
    private String fraseDelDia;

}
