package com.example.appcitasmedicas.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(value="appointments")
public class Appointment {

    @Id
    private final String id;
    private final String patientId;
    private final String doctorId;

}
