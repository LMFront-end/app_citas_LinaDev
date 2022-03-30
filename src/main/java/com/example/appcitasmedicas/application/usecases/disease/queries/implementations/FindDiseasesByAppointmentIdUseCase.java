package com.example.appcitasmedicas.application.usecases.disease.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DiseaseMapper;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindDiseasesByAppointmentId;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.repositories.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindDiseasesByAppointmentIdUseCase implements FindDiseasesByAppointmentId {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;

    @Override
    public Flux<DiseaseDTO> findDiseasesByAppointmentId(String id) {
        return diseaseRepository.findAllByAppointmentId(id).map(diseaseMapper.mapToDto());
    }
}
