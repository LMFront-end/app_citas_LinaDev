package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DoctorRepository extends ReactiveMongoRepository<Doctor, String> {

    Flux<Doctor> findAllByFirstNameContainsIgnoreCase(String name);
    Flux<Doctor> findAllByLastNameContainsIgnoreCase(String name);
}
