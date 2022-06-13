package com.example.domain.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class MedicationDto extends RepresentationModel<MedicationDto> {
    private Long id;

    private String name;

    private Integer quantity;
}
