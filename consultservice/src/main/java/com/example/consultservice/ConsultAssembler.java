package com.example.consultservice;

import com.example.doctorservice.DoctorController;
import com.example.domain.Consult;
import com.example.domain.Medication;
import com.example.domain.dto.ConsultDto;
import com.example.patientservice.PatientController;
import com.example.medicationservice.MedicationController;
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
        dto.add(linkTo(methodOn(DoctorController.class).getById(entity.getDoctor().getId())).withRel("doctor"));
        dto.add(linkTo(methodOn(PatientController.class).getById(entity.getPatient().getId())).withRel("patient"));
        for(Medication medication:entity.getMedications())
            dto.add(linkTo(methodOn(MedicationController.class).getMedicationById(medication.getId())).withRel("medication"));

        return dto;
    }
}
