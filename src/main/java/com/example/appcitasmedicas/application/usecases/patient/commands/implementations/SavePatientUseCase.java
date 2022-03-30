package com.example.appcitasmedicas.application.usecases.patient.commands.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.commands.interfaces.SavePatient;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SavePatientUseCase implements SavePatient {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Mono<PatientDTO> savePatient(PatientDTO patientDTO) {
        return patientRepository.save(patientMapper.mapToCollection().apply(patientDTO))
                .map(patientMapper.mapToDto());
    }
}
