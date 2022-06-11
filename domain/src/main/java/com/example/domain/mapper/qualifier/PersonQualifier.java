//package com.example.domain.mapper.qualifier;
//
//import com.example.domain.Doctor;
//import com.example.domain.Patient;
//import com.example.patients.model.Patient;
//import com.example.patients.service.DoctorService;
//import com.example.patients.service.PatientService;
//import org.mapstruct.Named;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PersonQualifier {
//
//    private final DoctorService doctorService;
//    private final PatientService patientService;
//
//    public PersonQualifier(DoctorService doctorService, PatientService patientService) {
//        this.doctorService = doctorService;
//        this.patientService = patientService;
//    }
//
//    @Named("idToDoctor")
//    public Doctor idToDoctor(Long id) {
//        return doctorService.getById(id);
//    }
//
//    @Named("idToPatient")
//    public Patient idToPatient(Long id) {
//        return patientService.getPatientById(id);
//    }
//}
