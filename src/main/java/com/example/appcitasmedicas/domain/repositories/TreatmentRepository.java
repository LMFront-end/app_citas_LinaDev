package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Treatment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends ReactiveMongoRepository<Treatment, String> {
}
