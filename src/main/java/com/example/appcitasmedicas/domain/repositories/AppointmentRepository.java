package com.example.appcitasmedicas.domain.repositories;

import com.example.appcitasmedicas.domain.collections.Appointment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends ReactiveMongoRepository<Appointment, String> {
}
