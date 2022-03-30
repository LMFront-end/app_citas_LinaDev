package com.example.appcitasmedicas.application.mappers;

import com.example.appcitasmedicas.domain.collections.Treatment;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreatmentMapper {

    public Function<Treatment, TreatmentDTO> mapToDto(){
        return treatment -> new TreatmentDTO(treatment.getId(),
                treatment.getDiseaseId(),
                treatment.getTreatmentName());
    }

    public Function<TreatmentDTO, Treatment> mapToCollection(){
        return treatmentDTO -> new Treatment(treatmentDTO.getId(),
                treatmentDTO.getDiseaseId(),
                treatmentDTO.getTreatmentName());
    }
}
