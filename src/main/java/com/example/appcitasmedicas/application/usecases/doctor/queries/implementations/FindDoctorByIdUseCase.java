package com.example.appcitasmedicas.application.usecases.doctor.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DoctorMapper;
import com.example.appcitasmedicas.application.usecases.doctor.queries.interfaces.FindDoctorById;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindDoctorByIdUseCase implements FindDoctorById {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Mono<DoctorDTO> findById(String id) {
        return doctorRepository.findById(id).map(doctorMapper.mapToDto());
    }
}
