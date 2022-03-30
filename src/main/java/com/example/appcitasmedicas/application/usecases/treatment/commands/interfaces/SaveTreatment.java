package com.example.appcitasmedicas.application.usecases.treatment.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveTreatment {
    Mono<TreatmentDTO> saveTreatment(TreatmentDTO treatmentDTO);
}
