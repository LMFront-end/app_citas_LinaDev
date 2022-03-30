package com.example.appcitasmedicas.application.usecases.disease.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindAllDiseases;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllDiseasesUseCase implements FindAllDiseases {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Flux<DiseaseDTO> findAllDiseases() {
        return diseaseRepository.findAll().map(diseaseMapper.mapToDto());
    }
}
