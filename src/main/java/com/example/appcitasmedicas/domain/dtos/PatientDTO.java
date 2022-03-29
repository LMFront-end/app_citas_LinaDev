package com.example.appcitasmedicas.domain.dtos;

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
}
