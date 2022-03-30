package com.example.appcitasmedicas.infrastructure.appointment.utils;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
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
public class AppointmentQueryRequestHandler {

    public BiFunction<ServerRequest, Flux<AppointmentDTO>, Mono<ServerResponse>> queryManyResponseHandler(){
        return (serverRequest, appointmentDTOFlux) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(appointmentDTOFlux, AppointmentDTO.class));
    }

    public BiFunction<ServerRequest, Mono<AppointmentDTO>, Mono<ServerResponse>> querySingleResponseHandler(){
        return (serverRequest, appointmentDTOMono) -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(appointmentDTOMono, AppointmentDTO.class));
    }
}
