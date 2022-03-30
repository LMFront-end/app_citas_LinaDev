package com.example.appcitasmedicas.domain.valueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails {

    private Gender gender;
    private CivilStatus civilStatus;
}
