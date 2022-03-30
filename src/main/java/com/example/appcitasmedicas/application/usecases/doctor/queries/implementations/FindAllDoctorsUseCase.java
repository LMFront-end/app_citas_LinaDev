package com.example.appcitasmedicas.application.usecases.doctor.queries.implementations;

import com.example.appcitasmedicas.application.mappers.DoctorMapper;
import com.example.appcitasmedicas.application.usecases.doctor.queries.interfaces.FindAllDoctors;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllDoctorsUseCase implements FindAllDoctors {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Flux<DoctorDTO> findAll() {
        return doctorRepository.findAll().map(doctorMapper.mapToDto());
    }
}
