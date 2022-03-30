package com.example.appcitasmedicas.application.usecases.treatment.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindTreatmentsByName {
    Flux<TreatmentDTO> findTreatmentByName(String name);
}
