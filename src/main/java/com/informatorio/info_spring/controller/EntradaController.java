package com.informatorio.info_spring.controller;

import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaCreateDto;
import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaDto;
import com.informatorio.info_spring.service.entradadiaria.EntradaDiariaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entrada-diaria")
@RequiredArgsConstructor
@Validated // Dice que todos los endpoints son validados con la librería de validación
public class EntradaController {

    private final EntradaDiariaService entradaDiariaService;


    @PostMapping
    public ResponseEntity<EntradaDiariaDto> create(
            @Valid @RequestBody EntradaDiariaCreateDto createDto
            // Valid se encarga de la validación de los campos del Dto(EntradaDiariaCreateDto)
    ){
        try {
            EntradaDiariaDto entradaCreada = entradaDiariaService.create(createDto);
            return ResponseEntity.ok(entradaCreada);
        } catch (IllegalArgumentException illegalArgumentException) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
