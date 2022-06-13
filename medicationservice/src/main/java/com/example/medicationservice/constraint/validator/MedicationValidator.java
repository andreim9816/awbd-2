package com.example.medicationservice.constraint.validator;

import com.example.medicationservice.MedicationService;
import com.example.medicationservice.constraint.annotation.ValidMedication;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MedicationValidator implements ConstraintValidator<ValidMedication, Long> {

    private final MedicationService medicationService;

    @Autowired
    public MedicationValidator(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @Override
    public boolean isValid(Long medicationId, ConstraintValidatorContext constraintValidatorContext) {
        if (medicationId == null) {
            return false;
        }
        return medicationService.checkIfMedicationExists(medicationId);
    }
}
