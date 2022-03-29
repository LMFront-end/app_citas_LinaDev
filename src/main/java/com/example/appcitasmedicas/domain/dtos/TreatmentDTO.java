package com.example.appcitasmedicas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDTO {

    private String id;
    private String diseaseId;
    private String TreatmentName;
}
