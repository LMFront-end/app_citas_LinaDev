package com.example.appcitasmedicas.infrastructure.treatment.utils;

import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class TreatmentCommandRequestHandler {

    public Function<TreatmentDTO, Mono<ServerResponse>> commandDTOResponse(){
        return treatmentDTO -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(treatmentDTO);
    }

    public Function<Mono<String>, Mono<ServerResponse>> commandEmptyResponseHandler(){
        return stringMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(stringMono, String.class));
    }
}
