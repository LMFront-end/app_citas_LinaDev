package com.example.appcitasmedicas.infrastructure.treatment.utils.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Component
public class PatientQueryRequestHandler {

    public BiFunction<ServerRequest, Flux<PatientDTO>, Mono<ServerResponse>> queryManyResponseHandler(){
        return (serverRequest, patientDTOFlux) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(patientDTOFlux, PatientDTO.class));
    }

    public BiFunction<ServerRequest, Mono<PatientDTO>, Mono<ServerResponse>> querySingleResponseHandler(){
        return (serverRequest, patientDTOMono) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(patientDTOMono, PatientDTO.class));
    }
}
