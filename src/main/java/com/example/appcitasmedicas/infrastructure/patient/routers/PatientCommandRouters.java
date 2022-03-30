package com.example.appcitasmedicas.infrastructure.patient.routers;

import com.example.appcitasmedicas.application.usecases.patient.commands.implementations.DeletePatientUseCase;
import com.example.appcitasmedicas.application.usecases.patient.commands.implementations.SavePatientUseCase;
import com.example.appcitasmedicas.application.usecases.patient.commands.implementations.UpdatePatientUseCase;
import com.example.appcitasmedicas.domain.dtos.PatientDTO;
import com.example.appcitasmedicas.infrastructure.patient.utils.PatientCommandRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class PatientCommandRouters {

    private final PatientCommandRequestHandler patientCommandRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> savePatientRouterFunction(SavePatientUseCase savePatientUseCase){
        return route(POST("api/patients/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PatientDTO.class).flatMap(savePatientUseCase::savePatient).flatMap(patientCommandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> updatePatientRouterFunction(UpdatePatientUseCase updatePatientUseCase){
        return route(PUT("api/patients/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PatientDTO.class).flatMap(updatePatientUseCase::updatePatient).flatMap(patientCommandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteDoctorRouterFunction(DeletePatientUseCase deletePatientUseCase){
        return route(DELETE("api/patients/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> patientCommandRequestHandler.commandEmptyResponseHandler().apply(deletePatientUseCase.deletePatient(request.pathVariable("id")))
        );
    }

}
