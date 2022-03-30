package com.example.appcitasmedicas.infrastructure.doctor.routers;

import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.DeleteDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.SaveDoctorUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.commands.implementations.UpdateDoctorUseCase;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
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
public class DoctorCommandRouters {

    private final DoctorCommandRequestHandler commandRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> saveDoctorRouterFunction(SaveDoctorUseCase saveDoctorUseCase){
         return route(POST("api/doctors/create").and(accept(MediaType.APPLICATION_JSON)),
                 request -> request.bodyToMono(DoctorDTO.class).flatMap(saveDoctorUseCase::saveDoctor).flatMap(commandRequestHandler.commandDTOResponse())
         );
     }

    @Bean
    public RouterFunction<ServerResponse> updateDoctorRouterFunction(UpdateDoctorUseCase updateDoctorUseCase){
        return route(PUT("api/doctors/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DoctorDTO.class).flatMap(updateDoctorUseCase::updateDoctor).flatMap(commandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteDoctorRouterFunction(DeleteDoctorUseCase deleteDoctorUseCase){
        return route(DELETE("api/doctors/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> commandRequestHandler.commandEmptyResponseHandler().apply(deleteDoctorUseCase.deleteDoctor(request.pathVariable("id")))
        );
    }

}
