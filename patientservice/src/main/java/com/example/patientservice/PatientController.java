package com.example.patientservice;

import com.example.domain.Patient;
import com.example.domain.dto.PatientDto;
import com.example.domain.dto.input.ReqPatientDto;
import com.example.domain.dto.input.update.ReqPatientUpdateDto;
import com.example.patientservice.constraint.annotation.ValidPatient;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
@Validated
@Api(value = "/patients",
        tags = "Patients")
public class PatientController {

    private final PatientService service;
    private final PatientAssesmbler assembler;
    private final PatientMapper mapper;

    @Autowired
    public PatientController(PatientService service, PatientAssesmbler assembler, PatientMapper mapper) {
        this.service = service;
        this.assembler = assembler;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(
            method = "GET",
            summary = "Get all patients"
    )
    public List<PatientDto> getAll() {
        return service.getAll().stream().map(assembler::toModel).collect(Collectors.toList());
    }

    @GetMapping("/{patient-id}")
    @Operation(
            method = "GET",
            summary = "Get a patient by ID"
    )
    public PatientDto getById(@PathVariable("patient-id") Long patientId) {
        return assembler.toModel(service.getById(patientId));
    }

    @PostMapping()
    @Operation(
            method = "POST",
            summary = "Save a new patient"
    )
    public PatientDto savePatient(@RequestBody @Valid ReqPatientDto reqPatient) {

        Patient patient = mapper.toEntityForCreate(reqPatient);
        Patient savedPatient = service.savePatient(patient);

        return assembler.toModel(savedPatient);
    }

    @PutMapping("/{patient-id}")
    @Operation(
            method = "PUT",
            summary = "Update a patient"
    )
    public PatientDto updatePatient(@PathVariable("patient-id") Long patientId,
                                    @RequestBody @Valid ReqPatientUpdateDto reqPatient) {

        Patient patient = service.getById(patientId);
        Patient updatedPatient = service.updatePatient(reqPatient, patient);

        return assembler.toModel(updatedPatient);

    }

    @DeleteMapping("/{patient-id}")
    @Operation(
            method = "DELETE",
            summary = "Delete a patient"
    )
    public void deletePatient(@PathVariable("patient-id") @ValidPatient Long patientId) {
        service.deletePatientById(patientId);
    }
}
