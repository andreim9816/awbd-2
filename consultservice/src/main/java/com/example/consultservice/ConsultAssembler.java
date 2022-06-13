package com.example.consultservice;

import com.example.domain.Consult;
import com.example.domain.Doctor;
import com.example.domain.dto.ConsultDto;
import com.example.domain.dto.DoctorDto;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ConsultAssembler implements RepresentationModelAssembler<Consult, ConsultDto> {

    private final ConsultMapper consultMapper;

    public ConsultAssembler(ConsultMapper consultMapper) {
        this.consultMapper = consultMapper;
    }

    @Override
    public ConsultDto toModel(Consult entity) {
        ConsultDto dto = consultMapper.toDto(entity);

        dto.add(linkTo(methodOn(ConsultController.class).getById(entity.getId())).withSelfRel());
//        dto.add(linkTo(methodOn(DoctorController.class).getAllConsultsOfDoctor(entity.getId())).withRel("consults"));


        return dto;
    }
}
