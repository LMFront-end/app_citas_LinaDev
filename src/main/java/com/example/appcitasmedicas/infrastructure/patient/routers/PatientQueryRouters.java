package com.example.appcitasmedicas.infrastructure.patient.routers;

import com.example.appcitasmedicas.application.usecases.patient.queries.implementations.FindAllPatientsUseCase;
import com.example.appcitasmedicas.application.usecases.patient.queries.implementations.FindPatientByIdUseCase;
import com.example.appcitasmedicas.application.usecases.patient.queries.implementations.FindPatientsByFirstNameUseCase;
import com.example.appcitasmedicas.application.usecases.patient.queries.implementations.FindPatientsByLastNameUseCase;
import com.example.appcitasmedicas.infrastructure.treatment.utils.utils.PatientQueryRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class PatientQueryRouters {

    private final PatientQueryRequestHandler patientQueryRequestHandler;

    @Bean
    public RouterFunction<ServerResponse> findAllPatientsRouterFunction(FindAllPatientsUseCase findAllPatientsUseCase){
        return route(GET("/api/patients"),
                request -> patientQueryRequestHandler.queryManyResponseHandler().apply(request, findAllPatientsUseCase.findAllPatients()));
    }

    @Bean
    public RouterFunction<ServerResponse> findPatientByIdRouterFunction(FindPatientByIdUseCase findPatientByIdUseCase){
        return route(GET("/api/patients/{id}"),
                request -> patientQueryRequestHandler.querySingleResponseHandler().apply(request, findPatientByIdUseCase.findPatientById(request.pathVariable("id"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findPatientsByFirstNameRouterFunction(FindPatientsByFirstNameUseCase findPatientsByFirstNameUseCase){
        return route(GET("/api/patients/firstName/{name}"),
                request -> patientQueryRequestHandler.queryManyResponseHandler().apply(request, findPatientsByFirstNameUseCase.findPatientsByFirstName(request.pathVariable("name"))));
    }

    @Bean
    public RouterFunction<ServerResponse> findPatientsByLastNameRouterFunction(FindPatientsByLastNameUseCase findPatientsByLastNameUseCase){
        return route(GET("/api/patients/lastName/{name}"),
                request -> patientQueryRequestHandler.queryManyResponseHandler().apply(request, findPatientsByLastNameUseCase.findPatientsByLastName(request.pathVariable("name"))));
    }

}
