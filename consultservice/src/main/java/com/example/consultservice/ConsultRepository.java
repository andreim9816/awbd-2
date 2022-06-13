package com.example.consultservice;

import com.example.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {

    List<Consult> getConsultsByDoctorIdAndPatientId(Long doctorId, Long patientId);
}
