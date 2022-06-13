package com.example.medicationservice;

import com.example.domain.Doctor;
import com.example.domain.Medication;
import com.example.domain.dto.DoctorDto;
import com.example.domain.dto.MedicationDto;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MedicationAssembler implements RepresentationModelAssembler<Medication, MedicationDto> {

    private final MedicationMapper medicationMapper;

    public MedicationAssembler(MedicationMapper medicationMapper) {
        this.medicationMapper = medicationMapper;
    }

    @Override
    public MedicationDto toModel(Medication entity) {
        MedicationDto dto = medicationMapper.toDto(entity);

        dto.add(linkTo(methodOn(MedicationController.class).getMedicationById(entity.getId())).withSelfRel());
//        dto.add(linkTo(methodOn(DoctorController.class).getAllConsultsOfDoctor(entity.getId())).withRel("consults"));


        return dto;
    }
}
