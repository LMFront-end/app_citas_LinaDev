package com.example.appcitasmedicas.application.usecases.disease.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindDiseasesByDiseaseName {

    Flux<DiseaseDTO> findDiseasesByDiseaseName(String name);

}
