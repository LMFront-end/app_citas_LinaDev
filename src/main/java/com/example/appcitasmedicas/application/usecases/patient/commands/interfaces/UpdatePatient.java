package com.example.appcitasmedicas.application.usecases.patient.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdatePatient {
    Mono<PatientDTO> updatePatient(PatientDTO patientDTO);
}
