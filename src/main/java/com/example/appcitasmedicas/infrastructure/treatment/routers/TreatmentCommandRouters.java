package com.example.appcitasmedicas.infrastructure.treatment.routers;

import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.DeleteDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.SaveDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.UpdateDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.commands.implementations.DeleteTreatmentUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.commands.implementations.SaveTreatmentUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.commands.implementations.UpdateTreatmentUseCase;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.dtos.TreatmentDTO;
import com.example.appcitasmedicas.infrastructure.doctor.utils.DoctorCommandRequestHandler;
import com.example.appcitasmedicas.infrastructure.treatment.utils.TreatmentCommandRequestHandler;
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
public class TreatmentCommandRouters {

    private final TreatmentCommandRequestHandler treatmentCommandRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> saveTreatmentRouterFunction(SaveTreatmentUseCase saveTreatmentUseCase){
         return route(POST("api/treatments/create").and(accept(MediaType.APPLICATION_JSON)),
                 request -> request.bodyToMono(TreatmentDTO.class).flatMap(saveTreatmentUseCase::saveTreatment).flatMap(treatmentCommandRequestHandler.commandDTOResponse())
         );
     }

    @Bean
    public RouterFunction<ServerResponse> updateTreatmentRouterFunction(UpdateTreatmentUseCase updateTreatmentUseCase){
        return route(PUT("api/treatments/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TreatmentDTO.class).flatMap(updateTreatmentUseCase::updateTreatment).flatMap(treatmentCommandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteTreatmentRouterFunction(DeleteTreatmentUseCase deleteTreatmentUseCase){
        return route(DELETE("api/treatments/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> treatmentCommandRequestHandler.commandEmptyResponseHandler().apply(deleteTreatmentUseCase.deleteTreatment(request.pathVariable("id")))
        );
    }

}
