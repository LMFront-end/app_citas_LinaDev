package com.example.appcitasmedicas.application.usecases.doctor.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindDoctorById {
    Mono<DoctorDTO> findById(String id);
}
