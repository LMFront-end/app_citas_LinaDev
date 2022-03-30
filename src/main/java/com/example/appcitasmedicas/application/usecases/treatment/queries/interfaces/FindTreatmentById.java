package com.example.appcitasmedicas.application.usecases.treatment.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindTreatmentById {
    Mono<TreatmentDTO> findTreatmentById(String id);
}
