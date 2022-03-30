package com.example.appcitasmedicas.application.usecases.appointment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces.FindAppointmentByPatientId;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAppointmentsByPatientIdUseCase implements FindAppointmentByPatientId {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Flux<AppointmentDTO> findByPatientId(String id) {
        return appointmentRepository.findAllByPatientId(id).map(appointmentMapper.mapToDTO());
    }
}
