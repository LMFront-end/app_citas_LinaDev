package com.example.appcitasmedicas.application.usecases.treatment.commands.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteTreatment {
    Mono<String> deleteTreatment(String id);
}
