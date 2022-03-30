package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Patient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PatientRepository extends ReactiveMongoRepository<Patient, String> {

    Flux<Patient> findAllByFirstNameContainsIgnoreCase(String name);
    Flux<Patient> findAllByLastNameContainsIgnoreCase(String name);

}
