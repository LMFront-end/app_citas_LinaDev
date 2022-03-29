package com.example.appcitasmedicas.domain.dtos;

import com.example.appcitasmedicas.domain.valueObjects.PatientDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private String id;
    private String firstName;
    private String lastName;
    private PatientDetails patientDetails;
}
