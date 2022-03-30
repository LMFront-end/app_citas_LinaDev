package com.example.appcitasmedicas.application.usecases.doctor.commands.implementations;

import com.example.appcitasmedicas.application.mappers.DoctorMapper;
import com.example.appcitasmedicas.application.usecases.doctor.commands.interfaces.SaveDoctor;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaveDoctorUseCase implements SaveDoctor {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Mono<DoctorDTO> saveDoctor(DoctorDTO doctorDTO) {
        return doctorRepository.save(doctorMapper.mapToCollection().apply(doctorDTO))
                .map(doctorMapper.mapToDto());
    }
}
