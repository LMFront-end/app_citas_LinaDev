package com.example.appcitasmedicas.application.usecases.treatment.commands.implementations;

import com.example.appcitasmedicas.application.mappers.TreatmentMapper;
import com.example.appcitasmedicas.application.usecases.treatment.commands.interfaces.DeleteTreatment;
import com.example.appcitasmedicas.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteTreatmentUseCase implements DeleteTreatment {

    private final TreatmentRepository treatmentRepository;

    @Override
    public Mono<String> deleteTreatment(String id) {
        return treatmentRepository.deleteById(id).thenReturn("El tratamiento con id " + id + " fue eliminado exitosamente");
    }
}
