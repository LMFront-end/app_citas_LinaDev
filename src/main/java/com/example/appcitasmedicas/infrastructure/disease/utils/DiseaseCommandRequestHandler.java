package com.example.appcitasmedicas.infrastructure.disease.utils;

import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class DiseaseCommandRequestHandler {

    public Function<DiseaseDTO, Mono<ServerResponse>> commandDTOResponse(){
        return diseaseDTO -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(diseaseDTO);
    }

    public Function<Mono<String>, Mono<ServerResponse>> commandEmptyResponseHandler(){
        return stringMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(stringMono, String.class));
    }
}
