package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends ReactiveMongoRepository<Doctor, String> {
}
