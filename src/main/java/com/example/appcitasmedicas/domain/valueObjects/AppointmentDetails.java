package com.example.appcitasmedicas.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDetails {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private final LocalDate date;
    private final AppointmentStatus appointmentStatus;
    private final Triage triage;
}
