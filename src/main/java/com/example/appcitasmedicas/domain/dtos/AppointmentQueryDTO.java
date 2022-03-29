package com.example.appcitasmedicas.domain.dtos;

import com.example.appcitasmedicas.domain.collections.Doctor;
import com.example.appcitasmedicas.domain.valueObjects.AppointmentDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentQueryDTO {

    private String id;
    private DoctorDTO doctorDTO;
    private PatientDTO patientDTO;
    private AppointmentDetails appointmentDetails;
}
