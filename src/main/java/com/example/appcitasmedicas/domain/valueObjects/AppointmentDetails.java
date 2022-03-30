package com.example.appcitasmedicas.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetails {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private AppointmentStatus appointmentStatus;
    private Triage triage;
}
