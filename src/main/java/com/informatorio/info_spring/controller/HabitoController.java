package com.informatorio.info_spring.controller;

import com.informatorio.info_spring.dto.habito.HabitoCreateDto;
import com.informatorio.info_spring.dto.habito.HabitoDto;
import com.informatorio.info_spring.dto.habito.HabitoView;
import com.informatorio.info_spring.service.habito.HabitoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habitos")
@Slf4j
public class HabitoController {

    private final HabitoService habitoService;

    @Autowired
    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @PostMapping
    public ResponseEntity<HabitoDto> createHabito(
            @Valid @RequestBody HabitoCreateDto habitoCreateDto
    ){
        HabitoDto nuevoHabito = habitoService.createHabito(habitoCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHabito);
    }

    @GetMapping ResponseEntity<List<HabitoView>> findAllProjectedBy(){
        List<HabitoView> habitos = habitoService.listarHabitos();
        return ResponseEntity.ok(habitos);
    }

}
