package com.example.appcitasmedicas.infrastructure.doctor.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class DoctorCommandRequestHandler {

    public Function<DoctorDTO, Mono<ServerResponse>> commandDTOResponse(){
        return doctorDTOMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(doctorDTOMono);
    }

    public Function<Mono<String>, Mono<ServerResponse>> commandEmptyResponseHandler(){
        return stringMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(stringMono, String.class));
    }
}
