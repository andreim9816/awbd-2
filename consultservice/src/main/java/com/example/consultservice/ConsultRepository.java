package com.example.consultservice;

import com.example.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {

    @Query(value="Select consult.* from consult WHERE consult.fk_doctor_id = :doctorId AND consult.fk_patient_id = :patientId", nativeQuery = true)
    List<Consult> getConsultsByDoctorIdAndPatientId(Long doctorId, Long patientId);
}
