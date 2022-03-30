package com.example.appcitasmedicas.application.usecases.disease.commands.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteDisease {
    Mono<String> deleteDisease(String id);
}
