package com.example.medicationservice;

import com.example.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    Medication findMedicationByNameAndQuantity(String name, Integer quantity);
}
