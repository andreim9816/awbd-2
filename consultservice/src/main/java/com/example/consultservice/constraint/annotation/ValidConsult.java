package com.example.consultservice.constraint.annotation;

import com.example.consultservice.constraint.validator.ConsultValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConsultValidator.class)
@Documented
public @interface ValidConsult {

    String message() default "Invalid consult ID!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}