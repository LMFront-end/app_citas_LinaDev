package com.example.appcitasmedicas.domain.valueObjects;

import lombok.Data;

@Data
public class PatientDetails {

    private final Gender gender;
    private final CivilStatus civilStatus;
}
