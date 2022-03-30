package com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindAppointmentById {
    Mono<AppointmentDTO> findById(String id);
}
