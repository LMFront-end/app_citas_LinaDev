package com.example.appcitasmedicas.application.usecases.doctor.commands.implementations;

import com.example.appcitasmedicas.application.mappers.DoctorMapper;
import com.example.appcitasmedicas.application.usecases.doctor.commands.interfaces.UpdateDoctor;
import com.example.appcitasmedicas.domain.dtos.DoctorDTO;
import com.example.appcitasmedicas.domain.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UpdateDoctorUseCase implements UpdateDoctor {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Mono<DoctorDTO> updateDoctor(DoctorDTO doctorDTO) {
        return doctorRepository.findById(doctorDTO.getId())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El doctor no fue encontrado en la base de datos")))
                .then(doctorRepository.save(doctorMapper.mapToCollection().apply(doctorDTO))
                        .map(doctorMapper.mapToDto()));
    }
}
