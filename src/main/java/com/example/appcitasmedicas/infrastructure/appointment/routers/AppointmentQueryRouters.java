package com.example.appcitasmedicas.infrastructure.appointment.routers;

import com.example.appcitasmedicas.application.usecases.appointment.queries.implementations.*;
import com.example.appcitasmedicas.application.usecases.appointment.queries.interfaces.FindAppointmentById;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindAllDoctorsUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorByIdUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByFirstNameUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByLastNameUseCase;
import com.example.appcitasmedicas.infrastructure.appointment.utils.AppointmentQueryRequestHandler;
import com.example.appcitasmedicas.infrastructure.doctor.utils.DoctorQueryRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class AppointmentQueryRouters {

    private final AppointmentQueryRequestHandler appointmentQueryRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> findAllAppointmentsRouterFunction(FindAllAppointmentsUseCase findAllAppointmentsUseCase){
        return route(GET("/api/appointments"),
                request -> appointmentQueryRequestHandler.queryManyResponseHandler().apply(request, findAllAppointmentsUseCase.findALL()));
    }

    @Bean
    public RouterFunction<ServerResponse> findAppointmentsByDateRouterFunction(FindAppointmentsByDateUseCase findAppointmentsByDateUseCase){
        return route(GET("api/appointments/date/{date}"),
                request -> appointmentQueryRequestHandler.queryManyResponseHandler().apply(request, findAppointmentsByDateUseCase
                        .findAppointmentsByDate(LocalDate.parse(request.pathVariable("date"), DateTimeFormatter.ofPattern("dd-MM-yyyy")))));
    }

    @Bean
    public RouterFunction<ServerResponse> findAppointmentByIdRouterFunction(FindAppointmentByIdUseCase findAppointmentByIdUseCase){
        return route(GET("/api/appointments/{id}"),
                request -> appointmentQueryRequestHandler.querySingleResponseHandler().apply(request, findAppointmentByIdUseCase.findById(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findAppointmentsByPatientIdRouterFunction(FindAppointmentsByPatientIdUseCase findAppointmentsByPatientIdUseCase){
        return route(GET("api/appointments/patientId/{id}"),
                request -> appointmentQueryRequestHandler.queryManyResponseHandler().apply(request, findAppointmentsByPatientIdUseCase
                        .findByPatientId(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findAppointmentsByDoctorIdRouterFunction(FindAppointmentsByDoctorIdUseCase findAppointmentsByDoctorIdUseCase){
        return route(GET("api/appointments/doctorId/{id}"),
                request -> appointmentQueryRequestHandler.queryManyResponseHandler().apply(request, findAppointmentsByDoctorIdUseCase
                        .findByDoctorId(request.pathVariable("id"))));
    }

}
