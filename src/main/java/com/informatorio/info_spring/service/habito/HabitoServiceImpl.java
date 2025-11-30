package com.informatorio.info_spring.service.habito;

import com.informatorio.info_spring.dto.habito.HabitoCreateDto;
import com.informatorio.info_spring.dto.habito.HabitoDto;
import com.informatorio.info_spring.dto.habito.HabitoView;
import com.informatorio.info_spring.mapper.habito.HabitoMapper;
import com.informatorio.info_spring.model.EntradaDiaria;
import com.informatorio.info_spring.model.Habito;
import com.informatorio.info_spring.repository.entradadiaria.EntradaDiariaRepository;
import com.informatorio.info_spring.repository.habito.HabitoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HabitoServiceImpl implements HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    @Autowired
    private EntradaDiariaRepository entradaDiariaRepository;


    @Override
    public HabitoDto createHabito(HabitoCreateDto habitoCreateDto) {
        Habito habito = HabitoMapper.toEntity(habitoCreateDto);

        habito = habitoRepository.save(habito);

        List<Long> entradaDiariaIds = habitoCreateDto.getEntradasDiariasIds();
        if (entradaDiariaIds != null && !entradaDiariaIds.isEmpty()) {
            List<EntradaDiaria> entradasEncontradas = entradaDiariaRepository.findAllById(entradaDiariaIds);

            for(EntradaDiaria entrada : entradasEncontradas) {
                entrada.getHabitos().add(habito);
                entradaDiariaRepository.save(entrada);
            }

            habito.setEntradasDiarias(entradasEncontradas);

        }

        return HabitoMapper.toDto(habito);
    }

    public List<HabitoView> listarHabitos() {
        return habitoRepository.findAllProjectedBy();
    }

}
