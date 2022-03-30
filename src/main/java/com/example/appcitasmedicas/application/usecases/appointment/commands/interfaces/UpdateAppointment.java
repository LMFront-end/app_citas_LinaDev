package com.example.appcitasmedicas.application.usecases.appointment.commands.interfaces;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateAppointment {
    Mono<AppointmentDTO> updateAppointment(AppointmentDTO appointmentDTO);
}
