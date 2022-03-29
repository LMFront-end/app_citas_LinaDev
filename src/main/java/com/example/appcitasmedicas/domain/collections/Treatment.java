package com.example.appcitasmedicas.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="treatments")
public class Treatment {

    @Id
    private final String id;
    private final String diseaseId;
    private final String TreatmentName;
}
