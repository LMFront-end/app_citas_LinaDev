package com.example.appcitasmedicas.application.usecases.treatment.queries.implementations;

import com.example.appcitasmedicas.application.mappers.TreatmentMapper;
import com.example.appcitasmedicas.application.usecases.treatment.queries.interfaces.FindTreatmentsByName;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import com.example.appcitasmedicas.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindTreatmentsByNameUseCase implements FindTreatmentsByName {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Override
    public Flux<TreatmentDTO> findTreatmentByName(String name) {
        return treatmentRepository.findAllByTreatmentNameContainsIgnoreCase(name).map(treatmentMapper.mapToDto());
    }
}
