package com.example.medicationservice;

import com.example.domain.Medication;
import com.example.domain.dto.MedicationDto;
import com.example.domain.dto.input.ReqMedicationDto;
import com.example.medicationservice.constraint.annotation.ValidMedication;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/medications")
@Validated
@Api(value = "/medications",
        tags = "Medications")
public class MedicationController {

    private final MedicationService medicationService;
    private final MedicationAssembler medicationAssembler;
    private final MedicationMapper medicationMapper;

    @Autowired
    public MedicationController(MedicationService medicationService, MedicationAssembler medicationAssembler, MedicationMapper medicationMapper) {
        this.medicationService = medicationService;
        this.medicationAssembler = medicationAssembler;
        this.medicationMapper = medicationMapper;
    }

    @GetMapping
    @Operation(
            method = "GET",
            summary = "Get all medications"
    )
    public List<MedicationDto> getAll() {

        return medicationService.getAllMedications()
                .stream().map(medicationAssembler::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{medication-id}")
    @Operation(
            method = "GET",
            summary = "Get a medication by ID"
    )
    public MedicationDto getMedicationById(@PathVariable("medication-id") Long medicationId) {
        return medicationAssembler.toModel(medicationService.getMedicationById(medicationId));
    }

    @PostMapping
    @Operation(
            method = "POST",
            summary = "Save a new medication"
    )
    public MedicationDto saveMedication(@RequestBody @Valid ReqMedicationDto reqMedication) {

        Medication medication = medicationMapper.toEntity(reqMedication);
        Medication savedMedication = medicationService.saveMedication(medication);

        return medicationAssembler.toModel(savedMedication);
    }

    @PutMapping("/{medication-id}")
    @Operation(
            method = "PUT",
            summary = "Update a medication"
    )
    public MedicationDto updateMedication(@PathVariable("medication-id") Long medicationId,
                                                          @RequestBody @Valid ReqMedicationDto reqMedication) {

        Medication medication = medicationService.getMedicationById(medicationId);
        Medication updatedMedication = medicationService.updateMedication(reqMedication, medication);

        return medicationAssembler.toModel(updatedMedication);
    }

    @DeleteMapping("/{medication-id}")
    @Operation(
            method = "DELETE",
            summary = "Delete a medication"
    )
    public void deleteDoctor(@PathVariable("medication-id") @ValidMedication Long medicationId) {

        medicationService.deleteMedicationById(medicationId);
    }
}

