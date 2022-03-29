package com.example.appcitasmedicas.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private String id;
    private String patientId;
    private String doctorId;
    private String disease;
}
