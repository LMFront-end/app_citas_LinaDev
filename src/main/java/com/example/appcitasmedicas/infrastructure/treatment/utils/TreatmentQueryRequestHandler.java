package com.example.appcitasmedicas.infrastructure.treatment.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Component
public class TreatmentQueryRequestHandler {

    public BiFunction<ServerRequest, Flux<TreatmentDTO>, Mono<ServerResponse>> queryManyResponseHandler(){
        return (serverRequest, treatmentDTOFlux) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(treatmentDTOFlux, TreatmentDTO.class));
    }

    public BiFunction<ServerRequest, Mono<TreatmentDTO>, Mono<ServerResponse>> querySingleResponseHandler(){
        return (serverRequest, treatmentDTOMono) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(treatmentDTOMono, TreatmentDTO.class));
    }
}
