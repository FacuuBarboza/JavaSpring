package com.informatorio.info_spring.dto.habito;

import com.informatorio.info_spring.model.NivelDeImportanciaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HabitoCreateDto {


    @NotBlank(message="La descripción del hábito es obligatoria")
    @Size(max=200, message="La descripción no puede exceder los 200 caracteres")
    private String descripcion;

    @NotNull(message="El nivel de importancia debe ser BAJO, MEDIO o ALTO")
    private NivelDeImportanciaEnum nivelDeImportancia;


    private List<Long> entradasDiariasIds;

}
