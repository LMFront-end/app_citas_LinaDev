package com.example.appcitasmedicas.application.usecases.doctor.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DoctorMapper;
import com.example.appcitasmedicas.application.usecases.doctor.queries.interfaces.FindDoctorsByFirstName;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindDoctorsByFirstNameUseCase implements FindDoctorsByFirstName {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Flux<DoctorDTO> findDoctorByFirstName(String name) {
        return doctorRepository.findAllByFirstNameContainsIgnoreCase(name).map(doctorMapper.mapToDto());
    }
}
