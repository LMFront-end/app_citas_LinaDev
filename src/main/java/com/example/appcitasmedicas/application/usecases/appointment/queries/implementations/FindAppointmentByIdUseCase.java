package com.example.appcitasmedicas.application.usecases.appointment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces.FindAppointmentById;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindAppointmentByIdUseCase implements FindAppointmentById {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Mono<AppointmentDTO> findById(String id) {
        return appointmentRepository.findById(id).map(appointmentMapper.mapToDTO());
    }
}
