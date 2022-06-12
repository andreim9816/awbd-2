package com.example.doctorservice;

import com.example.doctorservice.constraint.annotation.ValidDoctor;
import com.example.domain.Doctor;
import com.example.domain.dto.DoctorDto;
import com.example.domain.dto.input.ReqDoctorDto;
import com.example.domain.dto.input.update.ReqDoctorUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
@Validated
@Api(value = "/doctors",
        tags = "Doctors")
public class DoctorController {

    private final DoctorService service;
    private final DoctorAssembler assembler;
    private final DoctorMapper mapper;

    @Autowired
    public DoctorController(DoctorService service, DoctorAssembler assembler, DoctorMapper mapper) {
        this.service = service;
        this.assembler = assembler;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(
            method = "GET",
            summary = "Get all doctors"
    )
    public List<DoctorDto> getAll() {
        return service.getAll().stream().map(assembler::toModel).collect(Collectors.toList());
    }

    @GetMapping("/{doctor-id}")
    @Operation(
            method = "GET",
            summary = "Get a doctor by ID"
    )
    public DoctorDto getById(@PathVariable("doctor-id") Long doctorId) {
        return assembler.toModel(service.getById(doctorId));
    }

    @PostMapping()
    @Operation(
            method = "POST",
            summary = "Save a new doctor"
    )
    public DoctorDto saveDoctor(@RequestBody @Valid ReqDoctorDto reqDoctor) {

        Doctor doctor = mapper.toEntityForCreate(reqDoctor);
        Doctor savedDoctor = service.saveDoctor(doctor);

        return assembler.toModel(savedDoctor);
    }

    @PutMapping("/{doctor-id}")
    @Operation(
            method = "PUT",
            summary = "Update a doctor"
    )
    public DoctorDto updateDoctor(@PathVariable("doctor-id") Long doctorId,
                                  @RequestBody @Valid ReqDoctorUpdateDto reqDoctor) {

        Doctor doctor = service.getById(doctorId);
        Doctor updatedDoctor = service.updateDoctor(reqDoctor, doctor);

        return assembler.toModel(updatedDoctor);

    }

    @DeleteMapping("/{doctor-id}")
    @Operation(
            method = "DELETE",
            summary = "Delete a doctor"
    )
    public void deleteDoctor(@PathVariable("doctor-id") @ValidDoctor Long doctorId) {
        service.deleteDoctorById(doctorId);
    }
}
