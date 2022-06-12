//package com.example.doctorservice.constraint.validator;
//
//import com.example.doctorservice.constraint.annotation.UniqueCnp;
//import com.example.patients.service.PatientService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//
//public class UniqueCnpValidator implements ConstraintValidator<UniqueCnp, String> {
//
//    private final PatientService patientService;
//
//    @Autowired
//    public UniqueCnpValidator(PatientService patientService) {
//        this.patientService = patientService;
//    }
//
//    @Override
//    public boolean isValid(String cnp, ConstraintValidatorContext constraintValidatorContext) {
//        if (cnp == null) {
//            return false;
//        }
//        return !patientService.checkIfCnpExists(cnp);
//    }
//}
