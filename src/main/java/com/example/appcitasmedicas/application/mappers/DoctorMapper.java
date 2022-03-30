package com.example.appcitasmedicas.application.mappers;

import com.example.appcitasmedicas.domain.collections.Doctor;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DoctorMapper {

    public Function<Doctor, DoctorDTO> mapToDto(){
        return doctor -> new DoctorDTO(doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName());
    }

    public Function<DoctorDTO, Doctor> mapToCollection(){
        return doctorDTO -> new Doctor(doctorDTO.getId(),
                doctorDTO.getFirstName(),
                doctorDTO.getLastName());
    }
}
