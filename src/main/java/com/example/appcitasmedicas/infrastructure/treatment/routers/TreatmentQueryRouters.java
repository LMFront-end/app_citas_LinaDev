package com.example.appcitasmedicas.infrastructure.treatment.routers;

import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindAllDoctorsUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorByIdUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByFirstNameUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByLastNameUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.queries.implementations.FindAllTreatmentsUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.queries.implementations.FindTreatmentByIdUseCase;
import com.example.appcitasmedicas.application.usecases.treatment.queries.implementations.FindTreatmentsByNameUseCase;
import com.example.appcitasmedicas.infrastructure.doctor.utils.DoctorQueryRequestHandler;
import com.example.appcitasmedicas.infrastructure.treatment.utils.TreatmentQueryRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class TreatmentQueryRouters {

    private final TreatmentQueryRequestHandler treatmentQueryRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> findAllTreatmentsRouterFunction(FindAllTreatmentsUseCase findAllTreatmentsUseCase){
        return route(GET("/api/treatments"),
                request -> treatmentQueryRequestHandler.queryManyResponseHandler().apply(request, findAllTreatmentsUseCase.findAllTreatments()));
    }

    @Bean
    public RouterFunction<ServerResponse> findTreatmentByIdRouterFunction(FindTreatmentByIdUseCase findTreatmentByIdUseCase){
        return route(GET("/api/treatments/{id}"),
                request -> treatmentQueryRequestHandler.querySingleResponseHandler().apply(request, findTreatmentByIdUseCase.findTreatmentById(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findTreatmentsByNameRouterFunction(FindTreatmentsByNameUseCase findTreatmentsByNameUseCase){
        return route(GET("api/treatments/name/{name}"),
                request -> treatmentQueryRequestHandler.queryManyResponseHandler().apply(request, findTreatmentsByNameUseCase
                        .findTreatmentByName(request.pathVariable("name"))));
    }

}
