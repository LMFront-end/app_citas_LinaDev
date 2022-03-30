package com.example.appcitasmedicas.application.usecases.patient.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SavePatient {
    Mono<PatientDTO> savePatient(PatientDTO patientDTO);
}
