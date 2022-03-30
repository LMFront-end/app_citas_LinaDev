package com.example.appcitasmedicas.infrastructure.disease.routers;

import com.example.appcitasmedicas.application.usecases.disease.commands.implementations.DeleteDiseaseUseCase;
import com.example.appcitasmedicas.application.usecases.disease.commands.implementations.SaveDiseaseUseCase;
import com.example.appcitasmedicas.application.usecases.disease.commands.implementations.UpdateDiseaseUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.DeleteDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.SaveDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.UpdateDoctorUseCase;
import com.example.appcitasmedicas.domain.dtos.DiseaseDTO;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.infrastructure.disease.utils.DiseaseCommandRequestHandler;
import com.example.appcitasmedicas.infrastructure.doctor.utils.DoctorCommandRequestHandler;
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
public class DiseaseCommandRouters {

    private final DiseaseCommandRequestHandler diseaseCommandRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> saveDiseaseRouterFunction(SaveDiseaseUseCase saveDiseaseUseCase){
         return route(POST("api/diseases/create").and(accept(MediaType.APPLICATION_JSON)),
                 request -> request.bodyToMono(DiseaseDTO.class).flatMap(saveDiseaseUseCase::saveDisease).flatMap(diseaseCommandRequestHandler.commandDTOResponse())
         );
     }

    @Bean
    public RouterFunction<ServerResponse> updateDiseaseRouterFunction(UpdateDiseaseUseCase updateDiseaseUseCase){
        return route(PUT("api/diseases/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DiseaseDTO.class).flatMap(updateDiseaseUseCase::updateDisease).flatMap(diseaseCommandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteDiseaseRouterFunction(DeleteDiseaseUseCase deleteDiseaseUseCase){
        return route(DELETE("api/diseases/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> diseaseCommandRequestHandler.commandEmptyResponseHandler().apply(deleteDiseaseUseCase.deleteDisease(request.pathVariable("id")))
        );
    }

}
