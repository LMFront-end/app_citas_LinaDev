package com.example.appcitasmedicas.application.usecases.disease.commands.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.commands.interfaces.DeleteDisease;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteDiseaseUseCase implements DeleteDisease {

    private final DiseaseRepository diseaseRepository;

    @Override
    public Mono<String> deleteDisease(String id) {
        return diseaseRepository.deleteById(id).thenReturn("La enfermedad con id " + id + " ha sido eliminada");
    }
}
