package com.informatorio.info_spring.mapper.habito;

import com.informatorio.info_spring.dto.habito.HabitoCreateDto;
import com.informatorio.info_spring.dto.habito.HabitoDto;
import com.informatorio.info_spring.mapper.entradadiaria.EntradaDiariaMapper;
import com.informatorio.info_spring.model.Habito;

public final class HabitoMapper {

    public HabitoMapper(){

    };

    public static HabitoDto toDto(Habito habito){
        if (habito == null) return null;
        HabitoDto dto = new HabitoDto();
        dto.setId(habito.getId());
        dto.setDescripcion(habito.getDescripcion());
        dto.setNivelDeImportancia(habito.getNivelDeImportanciaEnum());

        if ( habito.getEntradasDiarias() != null && !habito.getEntradasDiarias().isEmpty()) {
            dto.setEntradasDiarias(
                    habito.getEntradasDiarias()
                            .stream()
                            .map(EntradaDiariaMapper::toDto)
                            .toList()
            );
        }

        return dto;



    }

    public static Habito toEntity(HabitoCreateDto habitoCreateDto){
        if (habitoCreateDto == null) return null;

        Habito habito = new Habito();
        habito.setDescripcion(habitoCreateDto.getDescripcion());
        habito.setNivelDeImportanciaEnum(habitoCreateDto.getNivelDeImportancia());

        return habito;
    }
}
