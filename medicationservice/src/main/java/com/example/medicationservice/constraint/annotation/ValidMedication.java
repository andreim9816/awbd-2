package com.example.medicationservice.constraint.annotation;

import com.example.medicationservice.constraint.validator.MedicationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MedicationValidator.class)
@Documented
public @interface ValidMedication {

    String message() default "Invalid medication ID!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
