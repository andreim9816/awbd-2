package com.example.doctorservice;

import com.example.domain.Doctor;
import com.example.domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.builder()
                        .entityId(id)
                        .entityType("Doctor")
                        .build()
                );
    }

    public Boolean checkIfDoctorExists(Long id) {
        return doctorRepository.findById(id).isPresent();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

//    public Doctor updateDoctor(ReqDoctorUpdateDto reqDoctorUpdateDto, Doctor doctor) {
//        Doctor updatedDoctor = doctorMapper.update(reqDoctorUpdateDto, doctor);
//
//        return saveDoctor(updatedDoctor);
//    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
