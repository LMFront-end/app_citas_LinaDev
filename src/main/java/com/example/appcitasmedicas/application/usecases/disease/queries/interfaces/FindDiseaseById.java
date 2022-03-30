package com.example.appcitasmedicas.application.usecases.disease.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindDiseaseById {

    Mono<DiseaseDTO> findDiseaseById(String id);

}
