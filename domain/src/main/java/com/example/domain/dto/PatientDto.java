package com.example.domain.dto;

import lombok.Data;

@Data
public class PatientDto extends PersonDto {

    private Long id;

    private String cnp;
}
