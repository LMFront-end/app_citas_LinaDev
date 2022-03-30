package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Treatment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TreatmentRepository extends ReactiveMongoRepository<Treatment, String> {

    Flux<Treatment> findAllByTreatmentNameContainsIgnoreCase(String name);
}
