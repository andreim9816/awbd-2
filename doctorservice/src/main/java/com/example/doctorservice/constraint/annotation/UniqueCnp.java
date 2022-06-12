//package com.example.doctorservice.constraint.annotation;
//
//import com.example.doctorservice.constraint.validator.UniqueCnpValidator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = UniqueCnpValidator.class)
//@Documented
//public @interface UniqueCnp {
//    String message() default "CNP already exists!";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}
