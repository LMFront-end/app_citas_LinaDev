package com.example.appcitasmedicas.application.usecases.patient.commands.implementations;

import com.example.appcitasmedicas.application.mappers.PatientMapper;
import com.example.appcitasmedicas.application.usecases.patient.commands.interfaces.UpdatePatient;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdatePatientUseCase implements UpdatePatient {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Mono<PatientDTO> updatePatient(PatientDTO patientDTO) {
        return patientRepository.findById(patientDTO.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El paciente no fue encontrado en la base de datos")))
                .then(patientRepository.save(patientMapper.mapToCollection().apply(patientDTO))
                        .map(patientMapper.mapToDto()));
    }
}
