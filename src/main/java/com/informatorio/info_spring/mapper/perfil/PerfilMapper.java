package com.informatorio.info_spring.mapper.perfil;

import com.informatorio.info_spring.dto.perfil.PerfilUsuarioDto;
import com.informatorio.info_spring.model.PerfilUsuario;

public final class PerfilMapper {

    private PerfilMapper() {
        // Constructor privado para evitar la instanciación
    }

    public static PerfilUsuarioDto toDto (PerfilUsuario perfilUsuario) {
        if (perfilUsuario == null) return null;

        PerfilUsuarioDto perfilUsuarioDto = new PerfilUsuarioDto();
        perfilUsuarioDto.setId(perfilUsuario.getId());
        perfilUsuarioDto.setBiografia(perfilUsuario.getBio());
        perfilUsuarioDto.setColorFavorito(perfilUsuario.getColorFavorito());
        perfilUsuarioDto.setFraseDelDia(perfilUsuario.getFraseDelDia());

        return perfilUsuarioDto;
    }

    public static PerfilUsuario toEntity (PerfilUsuarioDto perfilUsuarioDto) {
        if (perfilUsuarioDto == null) return null;

        PerfilUsuario perfilUsuario = new PerfilUsuario();
        perfilUsuario.setBio(perfilUsuarioDto.getBiografia());
        perfilUsuario.setColorFavorito(perfilUsuarioDto.getColorFavorito());
        perfilUsuario.setFraseDelDia(perfilUsuarioDto.getFraseDelDia());

        return perfilUsuario;
    }

    public static void updateEntity(PerfilUsuario perfilUsuario, PerfilUsuarioDto perfilUsuarioDto) {
        if (perfilUsuario == null || perfilUsuarioDto == null) return;

        perfilUsuario.setBio(perfilUsuarioDto.getBiografia());
        perfilUsuario.setColorFavorito(perfilUsuarioDto.getColorFavorito());
        perfilUsuario.setFraseDelDia(perfilUsuarioDto.getFraseDelDia());
    }



}
