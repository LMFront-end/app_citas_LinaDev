package com.example.appcitasmedicas.infrastructure.appointment.routers;

import com.example.appcitasmedicas.application.usecases.appointment.commands.implementations.DeleteAppointmentUseCase;
import com.example.appcitasmedicas.application.usecases.appointment.commands.implementations.SaveAppointmentUseCase;
import com.example.appcitasmedicas.application.usecases.appointment.commands.implementations.UpdateAppointmentUseCase;
import com.example.appcitasmedicas.domain.dtos.AppointmentDTO;
import com.example.appcitasmedicas.infrastructure.appointment.utils.AppointmentCommandRequestHandler;
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
public class AppointmentCommandRouters {

    private final AppointmentCommandRequestHandler appointmentCommandRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> saveAppointmentRouterFunction(SaveAppointmentUseCase saveAppointmentUseCase){
         return route(POST("api/appointments/create").and(accept(MediaType.APPLICATION_JSON)),
                 request -> request.bodyToMono(AppointmentDTO.class).flatMap(saveAppointmentUseCase::saveAppointment).flatMap(appointmentCommandRequestHandler.commandDTOResponse())
         );
     }

    @Bean
    public RouterFunction<ServerResponse> updateAppointmentRouterFunction(UpdateAppointmentUseCase updateAppointmentUseCase){
        return route(PUT("api/appointments/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(AppointmentDTO.class).flatMap(updateAppointmentUseCase::updateAppointment).flatMap(appointmentCommandRequestHandler.commandDTOResponse())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteAppointmentRouterFunction(DeleteAppointmentUseCase deleteAppointmentUseCase){
        return route(DELETE("api/appointments/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> appointmentCommandRequestHandler.commandEmptyResponseHandler().apply(deleteAppointmentUseCase.deleteAppointment(request.pathVariable("id")))
        );
    }

}
