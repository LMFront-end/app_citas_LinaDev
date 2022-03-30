package com.example.appcitasmedicas.application.usecases.patient.queries.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.queries.interfaces.FindPatientById;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindPatientByIdUseCase implements FindPatientById {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Mono<PatientDTO> findPatientById(String id) {
        return patientRepository.findById(id).map(patientMapper.mapToDto());
    }
}
