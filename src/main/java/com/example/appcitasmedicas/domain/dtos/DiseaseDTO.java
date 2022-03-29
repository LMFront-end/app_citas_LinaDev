package com.example.appcitasmedicas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseDTO {

    private String id;
    private String appointmentId;
    private String diseaseName;
}
