package com.example.consultservice;

import com.example.consultservice.constraint.annotation.ValidConsult;
import com.example.domain.Consult;
import com.example.domain.dto.ConsultDto;
import com.example.domain.dto.input.ReqConsultDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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

    @Autowired
    public ConsultController(ConsultService consultService, ConsultMapper consultMapper, ConsultAssembler consultAssembler) {
        this.consultService = consultService;
        this.consultMapper = consultMapper;
        this.consultAssembler = consultAssembler;
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

//    @GetMapping("/search")
//    @Operation(
//            method = "GET",
//            summary = "Get all consults between patient and doctor"
//    )
//    public List<ConsultDto> getAllConsultsForDoctorAndPatient(@RequestParam("doctorId") @ValidDoctor Long doctorId,
//                                                                              @RequestParam("patientId") @ValidPatient Long patientId) {
//
//        List<ConsultDto> result = new ArrayList<>();
//
//        List<Consult> consults = consultService.getAllConsultsForDoctorAndPatient(doctorId, patientId);
//
//        if (consults != null) {
//            result = consults.stream()
//                    .map(consultAssembler::toModel)
//                    .collect(Collectors.toList());
//        }
//        return result;
//    }

    @GetMapping("/{consult-id}")
    @Operation(
            method = "GET",
            summary = "Get a consult by ID"
    )
    public ConsultDto getById(@PathVariable("consult-id") Long consultId) {

        return consultAssembler.toModel(consultService.getConsultById(consultId));
    }

    @PostMapping
    @Operation(
            method = "POST",
            summary = "Save a new consult"
    )
    public ConsultDto saveConsult(@RequestBody @Valid ReqConsultDto reqConsult) {

        Consult consult = consultMapper.toEntity(reqConsult);
        Consult savedConsult = consultService.saveConsult(consult);

        return consultAssembler.toModel(savedConsult);
    }

    @PutMapping("/{consult-id}")
    @Operation(
            method = "PUT",
            summary = "Update a consult"
    )
    public ConsultDto updateConsult(@PathVariable("consult-id") Long consultId,
                                                    @RequestBody @Valid ReqConsultDto reqConsult) {

        Consult consult = consultService.getConsultById(consultId);
        Consult updatedConsult = consultService.updateConsult(reqConsult, consult);
        return consultAssembler.toModel(updatedConsult);
    }

    @DeleteMapping("/{consult-id}")
    @Operation(
            method = "DELETE",
            summary = "Delete a consult"
    )
    public void deleteDoctor(@PathVariable("consult-id") @ValidConsult Long consultId) {

        consultService.deleteConsultById(consultId);
    }

}
