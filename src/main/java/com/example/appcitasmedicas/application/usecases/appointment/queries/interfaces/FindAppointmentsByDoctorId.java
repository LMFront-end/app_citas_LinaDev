package com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAppointmentsByDoctorId {
    Flux<AppointmentDTO> findByDoctorId(String id);
}
