package com.informatorio.info_spring.mapper.entradadiaria;

import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaDto;
import com.informatorio.info_spring.mapper.usuario.UsuarioMapper;
import com.informatorio.info_spring.model.EntradaDiaria;
import com.informatorio.info_spring.model.Habito;

public final class EntradaDiariaMapper {

    public EntradaDiariaMapper(){

    }

    public static EntradaDiariaDto toDto(EntradaDiaria entradaDiaria){

        if (entradaDiaria == null) return null;
        EntradaDiariaDto dto = new EntradaDiariaDto();
        dto.setId(entradaDiaria.getId());
        dto.setFecha(entradaDiaria.getFecha());
        dto.setEmocion(entradaDiaria.getEmocion());
        dto.setUsuarioDto(UsuarioMapper.toDto(entradaDiaria.getUsuario()));
        dto.setReflexion(entradaDiaria.getReflexion());

        if ( entradaDiaria.getHabitos() != null && !entradaDiaria.getHabitos().isEmpty()){
            dto.setHabitosDescripciones(
                    entradaDiaria.getHabitos()
                            .stream()
                            .map(Habito::getDescripcion)
                            .toList()
            );
        }

        return dto;
//        return EntradaDiariaDto.builder()
//                .id(entradaDiaria.getId())
//                .fecha(entradaDiaria.getFecha())
//                .emocion(entradaDiaria.getEmocion())
//                .reflexion(entradaDiaria.getReflexion())
//                .usuarioId(entradaDiaria.getUsuario().getId())
//                .habitosIds(
//                        entradaDiaria.getHabitos()
//                                .stream()
//                                .map(Habito::getId)
//                                .collect(Collectors.toList())
//                )
//                .build();
    }

}
