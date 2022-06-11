package com.example.doctorservice;

import com.example.domain.dto.DoctorDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public DoctorController(DoctorService service, DoctorAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
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
//    @Operation(
//            method = "GET",
//            summary = "Get a doctor by ID"
//    )
    public DoctorDto getById(@PathVariable("doctor-id") Long doctorId) {
        return assembler.toModel(service.getById(doctorId));
    }

}
