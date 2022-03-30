package com.example.appcitasmedicas.application.usecases.appointment.commands.implementations;


import com.example.appcitasmedicas.application.usecases.appointment.commands.interfaces.DeleteAppointment;
import com.example.appcitasmedicas.domain.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteAppointmentUseCase implements DeleteAppointment {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Mono<String> deleteAppointment(String id) {
        return appointmentRepository.deleteById(id).thenReturn("La cita con id " + id + " fue eliminada exitosamente");
    }
}
