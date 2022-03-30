package com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@FunctionalInterface
public interface FindAppointmentsByDate {
    Flux<AppointmentDTO> findAppointmentsByDate(LocalDate localDate);
}
