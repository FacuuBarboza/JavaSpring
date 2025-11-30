package com.informatorio.info_spring.service.entradadiaria;

import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaCreateDto;
import com.informatorio.info_spring.dto.entradadiaria.EntradaDiariaDto;

public interface EntradaDiariaService {

    EntradaDiariaDto create(EntradaDiariaCreateDto createDto);

}
