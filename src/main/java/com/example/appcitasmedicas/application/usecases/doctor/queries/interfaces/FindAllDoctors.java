package com.example.appcitasmedicas.application.usecases.doctor.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllDoctors {
    Flux<DoctorDTO> findAll();
}
