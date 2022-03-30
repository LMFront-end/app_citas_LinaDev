package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Disease;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DiseaseRepository extends ReactiveMongoRepository<Disease, String> {

    Flux<Disease> findAllByDiseaseNameContainsIgnoreCase(String name);
    Flux<Disease> findAllByAppointmentId(String id);
}
