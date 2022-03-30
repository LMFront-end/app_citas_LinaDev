package com.example.appcitasmedicas.application.usecases.appointment.commands.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.commands.interfaces.SaveAppointment;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveAppointmentUseCase implements SaveAppointment {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Mono<AppointmentDTO> saveAppointment(AppointmentDTO appointmentDTO) {
        return appointmentRepository.save(appointmentMapper.mapToCollection().apply(appointmentDTO))
                .map(appointmentMapper.mapToDTO());
    }
}
