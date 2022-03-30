package com.example.appcitasmedicas.infrastructure.disease.routers;

import com.example.appcitasmedicas.application.usecases.disease.queries.implementations.FindAllDiseasesUseCase;
import com.example.appcitasmedicas.application.usecases.disease.queries.implementations.FindDiseasesByAppointmentIdUseCase;
import com.example.appcitasmedicas.application.usecases.disease.queries.implementations.FindDiseasesByDiseaseNameUseCase;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindDiseaseById;
import com.example.appcitasmedicas.application.usecases.disease.queries.interfaces.FindDiseasesByAppointmentId;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindAllDoctorsUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorByIdUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByFirstNameUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByLastNameUseCase;
import com.example.appcitasmedicas.infrastructure.disease.utils.DiseaseQueryRequestHandler;
import com.example.appcitasmedicas.infrastructure.doctor.utils.DoctorQueryRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class DiseaseQueryRouters {

    private final DiseaseQueryRequestHandler diseaseQueryRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> findAllDiseasesRouterFunction(FindAllDiseasesUseCase findAllDiseasesUseCase){
        return route(GET("/api/diseases"),
                request -> diseaseQueryRequestHandler.queryManyResponseHandler().apply(request, findAllDiseasesUseCase.findAllDiseases()));
    }

    @Bean
    public RouterFunction<ServerResponse> findDiseaseByIdRouterFunction(FindDiseaseById findDiseaseById){
        return route(GET("/api/diseases/{id}"),
                request -> diseaseQueryRequestHandler.querySingleResponseHandler().apply(request, findDiseaseById.findDiseaseById(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findDiseasesByAppointmentIdRouterFunction(FindDiseasesByAppointmentIdUseCase findDiseasesByAppointmentIdUseCase){
        return route(GET("api/diseases/appointmentId/{id}"),
                request -> diseaseQueryRequestHandler.queryManyResponseHandler().apply(request, findDiseasesByAppointmentIdUseCase
                        .findDiseasesByAppointmentId(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findDiseasesByDiseaseNameRouterFunction(FindDiseasesByDiseaseNameUseCase findDiseasesByDiseaseNameUseCase){
        return route(GET("api/diseases/diseaseName/{name}"),
                request -> diseaseQueryRequestHandler.queryManyResponseHandler().apply(request, findDiseasesByDiseaseNameUseCase
                        .findDiseasesByDiseaseName(request.pathVariable("name"))));
    }

}
