package com.example.doctorservice;

import com.example.domain.Doctor;
import com.example.domain.dto.input.update.ReqDoctorUpdateDto;
import com.example.domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper mapper) {
        this.repository = doctorRepository;
        this.mapper = mapper;
    }

    public List<Doctor> getAll() {
        return repository.findAll();
    }

    public Doctor getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.builder()
                        .entityId(id)
                        .entityType("Doctor")
                        .build()
                );
    }

    public Boolean checkIfDoctorExists(Long id) {
        return repository.findById(id).isPresent();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor updateDoctor(ReqDoctorUpdateDto reqDoctorUpdateDto, Doctor doctor) {
        Doctor updatedDoctor = mapper.update(reqDoctorUpdateDto, doctor);

        return saveDoctor(updatedDoctor);
    }

    public void deleteDoctorById(Long id) {
        repository.deleteById(id);
    }
}
