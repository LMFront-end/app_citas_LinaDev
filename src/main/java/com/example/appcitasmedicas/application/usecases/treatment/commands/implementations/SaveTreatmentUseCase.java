package com.example.appcitasmedicas.application.usecases.treatment.commands.implementations;

import com.example.appcitasmedicas.application.mappers.TreatmentMapper;
import com.example.appcitasmedicas.application.usecases.treatment.commands.interfaces.SaveTreatment;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import com.example.appcitasmedicas.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveTreatmentUseCase implements SaveTreatment {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public Mono<TreatmentDTO> saveTreatment(TreatmentDTO treatmentDTO) {
        return treatmentRepository.save(treatmentMapper.mapToCollection().apply(treatmentDTO))
                .map(treatmentMapper.mapToDto());
    }
}
