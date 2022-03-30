package com.example.appcitasmedicas.application.mappers;

import com.example.appcitasmedicas.domain.collections.Patient;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PatientMapper {

    public Function<Patient, PatientDTO> mapToDto(){
        return patient -> new PatientDTO(patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPatientDetails());
    }

    public Function<PatientDTO, Patient> mapToCollection(){
        return patientDTO -> new Patient(patientDTO.getId(),
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getPatientDetails());
    }
}
