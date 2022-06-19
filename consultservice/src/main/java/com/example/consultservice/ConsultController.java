package com.example.consultservice;

import com.example.consultservice.constraint.annotation.ValidConsult;
import com.example.doctorservice.constraint.annotation.ValidDoctor;
import com.example.domain.Consult;
import com.example.domain.Doctor;
import com.example.domain.Medication;
import com.example.domain.Patient;
import com.example.domain.dto.ConsultDto;
import com.example.domain.dto.DoctorDto;
import com.example.domain.dto.MedicationDto;
import com.example.domain.dto.PatientDto;
import com.example.domain.dto.input.ReqConsultDto;
import com.example.patientservice.constraint.annotation.ValidPatient;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/consults")
@Validated
@Api(value = "/consults",
        tags = "Consults")
public class ConsultController {

    private final ConsultService consultService;
    private final ConsultMapper consultMapper;
    private final ConsultAssembler consultAssembler;
    private final DoctorServiceProxy doctorServiceProxy;
    private final PatientServiceProxy patientServiceProxy;
    private final MedicationServiceProxy medicationServiceProxy;
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;
    private final MedicationMapper medicationMapper;

    @Autowired
    public ConsultController(ConsultService consultService, ConsultMapper consultMapper, ConsultAssembler consultAssembler,
                             DoctorServiceProxy doctorServiceProxy, PatientServiceProxy patientServiceProxy,
                             MedicationServiceProxy medicationServiceProxy, DoctorMapper doctorMapper, PatientMapper patientMapper, MedicationMapper medicationMapper) {
        this.consultService = consultService;
        this.consultMapper = consultMapper;
        this.consultAssembler = consultAssembler;
        this.doctorServiceProxy = doctorServiceProxy;
        this.patientServiceProxy = patientServiceProxy;
        this.medicationServiceProxy = medicationServiceProxy;
        this.doctorMapper = doctorMapper;
        this.patientMapper = patientMapper;
        this.medicationMapper = medicationMapper;
    }

    @GetMapping
    @Operation(
            method = "GET",
            summary = "Get all consults"
    )
    public List<ConsultDto> getAll() {

        return consultService.getAllConsults().stream()
                .map(consultAssembler::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    @Operation(
            method = "GET",
            summary = "Get all consults between patient and doctor"
    )
    public List<ConsultDto> getAllConsultsForDoctorAndPatient(@RequestParam("doctorId") Long doctorId,
                                                                              @RequestParam("patientId") Long patientId) {

        List<ConsultDto> result = new ArrayList<>();

        List<Consult> consults = consultService.getAllConsultsForDoctorAndPatient(doctorId, patientId);

        if (consults != null) {
            result = consults.stream()
                    .map(consultAssembler::toModel)
                    .collect(Collectors.toList());
        }
        return result;
    }

    @GetMapping("/{consult-id}")
    @Operation(
            method = "GET",
            summary = "Get a consult by ID"
    )
    public ConsultDto getById(@PathVariable("consult-id") Long consultId) {

        return consultAssembler.toModel(consultService.getConsultById(consultId));
    }

    public Consult feignForConsult(ReqConsultDto reqConsult){
        List<Medication> medicationList = new ArrayList<>();
        Long doctorId = reqConsult.getDoctorId();
        Long patientId = reqConsult.getPatientId();
        List<Long> ids = reqConsult.getMedicationIds();

        for (Long id:ids)
        {
            MedicationDto medicationDto = medicationServiceProxy.findById(id);
            Medication medication = medicationMapper.toEntity(medicationDto);
            medicationList.add(medication);
        }

        DoctorDto doctorDto = doctorServiceProxy.findById(doctorId);
        PatientDto patientDto = patientServiceProxy.findById(patientId);

        Doctor doctor = doctorMapper.toEntity(doctorDto);
        Patient patient = patientMapper.toEntity(patientDto);

        Consult consult = consultMapper.toEntity(reqConsult);
        consult.setDoctor(doctor);
        consult.setPatient(patient);
        consult.setMedications(medicationList);
        return consult;
    }
    @PostMapping
    @Operation(
            method = "POST",
            summary = "Save a new consult"
    )
    public ConsultDto saveConsult(@RequestBody @Valid ReqConsultDto reqConsult) {

        Consult savedConsult = consultService.saveConsult(feignForConsult(reqConsult));

        return consultAssembler.toModel(savedConsult);
    }

    @PutMapping("/{consult-id}")
    @Operation(
            method = "PUT",
            summary = "Update a consult"
    )
    public ConsultDto updateConsult(@PathVariable("consult-id") Long consultId,
                                    @RequestBody @Valid ReqConsultDto reqConsult) {

        Consult consultToBeUpdated = consultService.getConsultById(consultId);
        Consult updatedConsult = consultService.updateConsult(feignForConsult(reqConsult), consultToBeUpdated);
        return consultAssembler.toModel(updatedConsult);
    }

    @DeleteMapping("/{consult-id}")
    @Operation(
            method = "DELETE",
            summary = "Delete a consult"
    )
    public void deleteConsult(@PathVariable("consult-id") @ValidConsult Long consultId) {

        consultService.deleteConsultById(consultId);
    }

}
