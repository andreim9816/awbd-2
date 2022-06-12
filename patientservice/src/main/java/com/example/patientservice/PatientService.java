package com.example.patientservice;

import com.example.domain.Patient;
import com.example.domain.dto.input.update.ReqPatientUpdateDto;
import com.example.domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientService(PatientRepository patientRepository, PatientMapper mapper) {
        this.repository = patientRepository;
        this.mapper = mapper;
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Patient getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.builder()
                        .entityId(id)
                        .entityType("Patient")
                        .build()
                );
    }

    public Boolean checkIfCnpExists(String cnp) {
        return repository.getByCnp(cnp) != null;
    }

    public Boolean checkIfPatientExists(Long id) {
        return repository.findById(id).isPresent();
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updatePatient(ReqPatientUpdateDto reqPatientUpdateDto, Patient patient) {
        Patient updatedPatient = mapper.update(reqPatientUpdateDto, patient);

        return savePatient(updatedPatient);
    }

    public void deletePatientById(Long id) {
        repository.deleteById(id);
    }
}
