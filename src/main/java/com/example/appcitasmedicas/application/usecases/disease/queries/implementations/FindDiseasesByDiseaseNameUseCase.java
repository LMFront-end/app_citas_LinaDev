package com.example.appcitasmedicas.application.usecases.disease.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindDiseasesByDiseaseName;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindDiseasesByDiseaseNameUseCase implements FindDiseasesByDiseaseName {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Flux<DiseaseDTO> findDiseasesByDiseaseName(String name) {
        return diseaseRepository.findAllByDiseaseNameContainsIgnoreCase(name).map(diseaseMapper.mapToDto());
    }
}
