package com.example.appcitasmedicas.application.usecases.doctor.commands.implementations;

import com.example.appcitasmedicas.application.usecases.doctor.commands.interfaces.DeleteDoctor;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteDoctorUseCase implements DeleteDoctor {

    private final DoctorRepository doctorRepository;

    @Override
    public Mono<String> deleteDoctor(String id) {
        return doctorRepository.deleteById(id).thenReturn("El doctor con id " + id + " fue eliminado exitosamente");
    }
}
