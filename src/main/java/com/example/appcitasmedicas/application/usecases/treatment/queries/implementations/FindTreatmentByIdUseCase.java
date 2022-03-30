package com.example.appcitasmedicas.application.usecases.treatment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.TreatmentMapper;
import com.example.appcitasmedicas.application.usecases.treatment.queries.interfaces.FindTreatmentById;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import com.example.appcitasmedicas.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindTreatmentByIdUseCase implements FindTreatmentById {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public Mono<TreatmentDTO> findTreatmentById(String id) {
        return treatmentRepository.findById(id).map(treatmentMapper.mapToDto());
    }
}
