package com.example.appcitasmedicas.infrastructure.doctor.routers;

import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindAllDoctorsUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorByIdUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByFirstNameUseCase;
import com.example.appcitasmedicas.application.usecases.doctor.queries.implementations.FindDoctorsByLastNameUseCase;
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
public class DoctorQueryRouters {

    private final DoctorQueryRequestHandler requestHandler;

    @Bean
    public RouterFunction<ServerResponse> findAllDoctorsRouterFunction(FindAllDoctorsUseCase findAllDoctorsUseCase){
        return route(GET("/api/doctors"),
                request -> requestHandler.queryManyResponseHandler().apply(request, findAllDoctorsUseCase.findAll()));
    }

    @Bean
    public RouterFunction<ServerResponse> findDoctorByIdRouterFunction(FindDoctorByIdUseCase findDoctorByIdUseCase){
        return route(GET("/api/doctors/{id}"),
                request -> requestHandler.querySingleResponseHandler().apply(request, findDoctorByIdUseCase.findById(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findDoctorsByFirstNameRouterFunction(FindDoctorsByFirstNameUseCase findDoctorsByFirstNameUseCase){
        return route(GET("api/doctors/firstName/{name}"),
                request -> requestHandler.queryManyResponseHandler().apply(request, findDoctorsByFirstNameUseCase
                        .findDoctorByFirstName(request.pathVariable("name"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findDoctorsByLastNameRouterFunction(FindDoctorsByLastNameUseCase findDoctorsByLastNameUseCase){
        return route(GET("api/doctors/lastName/{name}"),
                request -> requestHandler.queryManyResponseHandler().apply(request, findDoctorsByLastNameUseCase
                        .findDoctorsByLastName(request.pathVariable("name"))));
    }

}
