package com.informatorio.info_spring.service.habito;

import com.informatorio.info_spring.dto.habito.HabitoCreateDto;
import com.informatorio.info_spring.dto.habito.HabitoDto;
import com.informatorio.info_spring.dto.habito.HabitoView;

import java.util.List;

public interface HabitoService {

    HabitoDto createHabito(HabitoCreateDto habitoCreateDto);
    List<HabitoView> listarHabitos();
}
