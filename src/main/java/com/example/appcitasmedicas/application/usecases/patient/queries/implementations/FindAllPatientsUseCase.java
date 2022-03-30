package com.example.appcitasmedicas.application.usecases.patient.queries.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.queries.interfaces.FindAllPatients;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllPatientsUseCase implements FindAllPatients {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Flux<PatientDTO> findAllPatients() {
        return patientRepository.findAll().map(patientMapper.mapToDto());
    }
}
