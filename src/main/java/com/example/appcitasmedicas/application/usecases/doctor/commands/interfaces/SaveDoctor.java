package com.example.appcitasmedicas.application.usecases.doctor.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveDoctor {
    Mono<DoctorDTO> saveDoctor(DoctorDTO doctorDTO);
}
