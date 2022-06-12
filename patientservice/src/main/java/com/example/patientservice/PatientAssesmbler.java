package com.example.patientservice;

import com.example.domain.Patient;
import com.example.domain.dto.PatientDto;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PatientAssesmbler implements RepresentationModelAssembler<Patient, PatientDto> {

    private final PatientMapper patientMapper;

    public PatientAssesmbler(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDto toModel(Patient entity) {
        PatientDto dto = patientMapper.toDto(entity);

        dto.add(linkTo(methodOn(PatientController.class).getById(entity.getId())).withSelfRel());
//        dto.add(linkTo(methodOn(PatientController.class).getAllConsultsOfPatient(entity.getId())).withRel("consults"));


        return dto;
    }
}
