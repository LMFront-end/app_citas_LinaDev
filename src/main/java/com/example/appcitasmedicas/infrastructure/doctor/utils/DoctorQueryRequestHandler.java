package com.example.appcitasmedicas.infrastructure.doctor.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Component
public class DoctorQueryRequestHandler {

    public BiFunction<ServerRequest, Flux<DoctorDTO>, Mono<ServerResponse>> queryManyResponseHandler(){
        return (serverRequest, doctorDTOFlux) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(doctorDTOFlux, DoctorDTO.class));
    }

    public BiFunction<ServerRequest, Mono<DoctorDTO>, Mono<ServerResponse>> querySingleResponseHandler(){
        return (serverRequest, doctorDTOMono) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(doctorDTOMono, DoctorDTO.class));
    }
}
