package com.example.appcitasmedicas.application.usecases.appointment.commands.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.commands.interfaces.UpdateAppointment;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateAppointmentUseCase implements UpdateAppointment {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Mono<AppointmentDTO> updateAppointment(AppointmentDTO appointmentDTO) {
        return appointmentRepository.findById(appointmentDTO.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("La cita no se encuentra en la base de datos")))
                .then(appointmentRepository.save(appointmentMapper.mapToCollection().apply(appointmentDTO))
                        .map(appointmentMapper.mapToDTO()));
    }
}
