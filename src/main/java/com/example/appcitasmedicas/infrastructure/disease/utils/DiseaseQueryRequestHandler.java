package com.example.appcitasmedicas.infrastructure.disease.utils;

import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
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
public class DiseaseQueryRequestHandler {

    public BiFunction<ServerRequest, Flux<DiseaseDTO>, Mono<ServerResponse>> queryManyResponseHandler(){
        return (serverRequest, diseaseDTOFlux) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(diseaseDTOFlux, DiseaseDTO.class));
    }

    public BiFunction<ServerRequest, Mono<DiseaseDTO>, Mono<ServerResponse>> querySingleResponseHandler(){
        return (serverRequest, diseaseDTOMono) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(diseaseDTOMono, DiseaseDTO.class));
    }
}
