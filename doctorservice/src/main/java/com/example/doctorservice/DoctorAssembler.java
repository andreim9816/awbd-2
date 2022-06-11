package com.example.doctorservice;

import com.example.domain.Doctor;
import com.example.domain.dto.DoctorDto;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DoctorAssembler implements RepresentationModelAssembler<Doctor, DoctorDto> {

    private final DoctorMapper doctorMapper;

    public DoctorAssembler(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDto toModel(Doctor entity) {
        DoctorDto dto = doctorMapper.toDto(entity);

        dto.add(linkTo(methodOn(DoctorController.class).getById(entity.getId())).withSelfRel());
//        dto.add(linkTo(methodOn(DoctorController.class).getAllConsultsOfDoctor(entity.getId())).withRel("consults"));


        return dto;
    }
}
