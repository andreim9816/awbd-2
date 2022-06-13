package com.example.consultservice.constraint.validator;

import com.example.consultservice.ConsultService;
import com.example.consultservice.constraint.annotation.ValidConsult;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConsultValidator implements ConstraintValidator<ValidConsult, Long> {

    private final ConsultService consultService;

    @Autowired
    public ConsultValidator(ConsultService consultService) {
        this.consultService = consultService;
    }

    @Override
    public boolean isValid(Long consultId, ConstraintValidatorContext constraintValidatorContext) {
        if (consultId == null) {
            return false;
        }
        return consultService.checkIfConsultExists(consultId);
    }
}
