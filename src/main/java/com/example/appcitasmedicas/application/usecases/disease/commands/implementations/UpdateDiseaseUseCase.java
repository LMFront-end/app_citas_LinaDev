package com.example.appcitasmedicas.application.usecases.disease.commands.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.commands.interfaces.UpdateDisease;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateDiseaseUseCase implements UpdateDisease {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Mono<DiseaseDTO> updateDisease(DiseaseDTO diseaseDTO) {
        return diseaseRepository.findById(diseaseDTO.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("La enfermedad no se encuentra en la base de datos")))
                .then(diseaseRepository.save(diseaseMapper.mapToCollection().apply(diseaseDTO))
                        .map(diseaseMapper.mapToDto()));
    }
}
