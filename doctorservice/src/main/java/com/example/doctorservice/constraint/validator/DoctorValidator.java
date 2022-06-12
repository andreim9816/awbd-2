package com.example.doctorservice.constraint.validator;

import com.example.doctorservice.DoctorService;
import com.example.doctorservice.constraint.annotation.ValidDoctor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoctorValidator implements ConstraintValidator<ValidDoctor, Long> {

    private final DoctorService doctorService;

    @Autowired
    public DoctorValidator(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public boolean isValid(Long doctorId, ConstraintValidatorContext constraintValidatorContext) {
        if (doctorId == null) {
            return false;
        }
        return doctorService.checkIfDoctorExists(doctorId);
    }
}
