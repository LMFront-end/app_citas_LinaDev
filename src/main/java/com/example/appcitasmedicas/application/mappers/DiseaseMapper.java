package com.example.appcitasmedicas.application.mappers;

import com.example.appcitasmedicas.domain.collections.Disease;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DiseaseMapper {

    public Function<Disease, DiseaseDTO> mapToDto(){
        return disease -> new DiseaseDTO(disease.getId(),
                disease.getAppointmentId(),
                disease.getDiseaseName());
    }

    public Function<DiseaseDTO, Disease> mapToCollection(){
        return diseaseDTO -> new Disease(diseaseDTO.getId(),
                diseaseDTO.getAppointmentId(),
                diseaseDTO.getDiseaseName());
    }
}
