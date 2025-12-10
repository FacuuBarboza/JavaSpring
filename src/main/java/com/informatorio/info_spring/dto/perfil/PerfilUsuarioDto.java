package com.informatorio.info_spring.dto.perfil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max=1000)
    private String biografia;

    @NotBlank(message = "El color favorito no puede estar vacío")
    @Size(max=15)
    private String colorFavorito;

    @NotBlank(message = "La frase del día no puede estar vacía")
    @Size(max=150)
    private String fraseDelDia;

}
