package com.example.appcitasmedicas.application.usecases.disease.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindDiseaseById;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindDiseaseByIdUseCase implements FindDiseaseById {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Mono<DiseaseDTO> findDiseaseById(String id) {
        return diseaseRepository.findById(id).map(diseaseMapper.mapToDto());
    }

}
