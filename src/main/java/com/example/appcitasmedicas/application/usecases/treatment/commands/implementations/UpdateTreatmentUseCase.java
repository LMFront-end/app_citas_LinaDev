package com.example.appcitasmedicas.application.usecases.treatment.commands.implementations;

import com.example.appcitasmedicas.application.mappers.TreatmentMapper;
import com.example.appcitasmedicas.application.usecases.treatment.commands.interfaces.UpdateTreatment;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import com.example.appcitasmedicas.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateTreatmentUseCase implements UpdateTreatment {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public Mono<TreatmentDTO> updateTreatment(TreatmentDTO treatmentDTO) {
        return treatmentRepository.findById(treatmentDTO.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El tratamiento no fue encontrado en la base de datos")))
                .then(treatmentRepository.save(treatmentMapper.mapToCollection().apply(treatmentDTO))
                        .map(treatmentMapper.mapToDto()));
    }
}
