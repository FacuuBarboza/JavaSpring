package com.informatorio.info_spring.repository.habito;

import com.informatorio.info_spring.dto.habito.HabitoView;
import com.informatorio.info_spring.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long> {

    List<HabitoView> findAllProjectedBy();
}
