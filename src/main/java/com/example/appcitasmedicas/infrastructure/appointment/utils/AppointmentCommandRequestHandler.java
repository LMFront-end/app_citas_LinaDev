package com.example.appcitasmedicas.infrastructure.appointment.utils;

import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class AppointmentCommandRequestHandler {

    public Function<AppointmentDTO, Mono<ServerResponse>> commandDTOResponse(){
        return appointmentDTO -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(appointmentDTO);
    }

    public Function<Mono<String>, Mono<ServerResponse>> commandEmptyResponseHandler(){
        return stringMono -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(stringMono, String.class));
    }
}
