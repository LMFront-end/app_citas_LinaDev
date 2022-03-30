package com.example.appcitasmedicas.application.usecases.patient.commands.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeletePatient {
    Mono<String> deletePatient(String id);
}
