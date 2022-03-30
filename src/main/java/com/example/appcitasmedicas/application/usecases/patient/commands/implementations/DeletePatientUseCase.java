package com.example.appcitasmedicas.application.usecases.patient.commands.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.commands.interfaces.DeletePatient;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeletePatientUseCase implements DeletePatient {

    private final PatientRepository patientRepository;

    @Override
    public Mono<String> deletePatient(String id) {
        return patientRepository.deleteById(id).thenReturn("El paciente con id " + id + " ha sido eliminado exitosamente");
    }
}
