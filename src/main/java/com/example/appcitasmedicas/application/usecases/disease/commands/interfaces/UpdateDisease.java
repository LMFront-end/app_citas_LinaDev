package com.example.appcitasmedicas.application.usecases.disease.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateDisease {
    Mono<DiseaseDTO> updateDisease(DiseaseDTO diseaseDTO);
}
