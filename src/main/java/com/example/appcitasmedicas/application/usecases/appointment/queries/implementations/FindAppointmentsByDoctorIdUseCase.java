package com.example.appcitasmedicas.application.usecases.appointment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces.FindAppointmentsByDoctorId;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAppointmentsByDoctorIdUseCase implements FindAppointmentsByDoctorId {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Flux<AppointmentDTO> findByDoctorId(String id) {
        return appointmentRepository.findAllByDoctorId(id).map(appointmentMapper.mapToDTO());
    }
}
