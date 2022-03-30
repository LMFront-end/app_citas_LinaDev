package com.example.appcitasmedicas.infrastructure.patient.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class PatientCommandRequestHandler {

    public Function<PatientDTO, Mono<ServerResponse>> commandDTOResponse(){
        return patientDTO -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(patientDTO);
    }

    public Function<Mono<String>, Mono<ServerResponse>> commandEmptyResponseHandler(){
        return stringMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(stringMono, String.class));
    }
}
