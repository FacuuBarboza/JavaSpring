package com.informatorio.info_spring.dto.habito;

import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaDto;
import com.informatorio.info_spring.model.NivelDeImportanciaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HabitoDto {

    private Long id;
    private String descripcion;
    private NivelDeImportanciaEnum nivelDeImportancia;
    private List<EntradaDiariaDto> entradasDiarias;

}
