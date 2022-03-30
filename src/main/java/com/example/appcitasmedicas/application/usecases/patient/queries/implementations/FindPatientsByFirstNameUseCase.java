package com.example.appcitasmedicas.application.usecases.patient.queries.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.queries.interfaces.FindPatientsByFirstName;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindPatientsByFirstNameUseCase implements FindPatientsByFirstName {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Flux<PatientDTO> findPatientsByFirstName(String name) {
        return patientRepository.findAllByFirstNameContainsIgnoreCase(name).map(patientMapper.mapToDto());
    }
}
