package com.example.appcitasmedicas.application.usecases.disease.commands.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.commands.interfaces.SaveDisease;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveDiseaseUseCase implements SaveDisease {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Mono<DiseaseDTO> saveDisease(DiseaseDTO diseaseDTO) {
        return diseaseRepository.save(diseaseMapper.mapToCollection().apply(diseaseDTO))
                .map(diseaseMapper.mapToDto());
    }
}
