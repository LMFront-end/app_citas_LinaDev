package com.example.appcitasmedicas.application.usecases.appointment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.AppointmentMapper;
import com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces.FindAppointmentsByDate;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FindAppointmentsByDateUseCase implements FindAppointmentsByDate {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;


    @Override
    public Flux<AppointmentDTO> findAppointmentsByDate(LocalDate localDate) {
        return appointmentRepository.findAllByAppointmentDetails_Date(localDate)
                .map(appointmentMapper.mapToDTO());
    }
}
