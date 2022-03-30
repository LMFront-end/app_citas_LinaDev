package com.example.appcitasmedicas.application.usecases.patient.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindPatientById {
    Mono<PatientDTO> findPatientById(String id);
}
