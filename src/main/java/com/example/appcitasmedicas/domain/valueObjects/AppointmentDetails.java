package com.example.appcitasmedicas.domain.valueObjects;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDetails {

    private final LocalDate date;
    private final AppointmentStatus appointmentStatus;
    private final Triage triage;
}
