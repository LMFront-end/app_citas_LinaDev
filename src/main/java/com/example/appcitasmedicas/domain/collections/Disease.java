package com.example.appcitasmedicas.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="diseases")
public class Disease {

    @Id
    private final String id;
    private final String appointmentId;
    private final String diseaseName;
}
