package com.example.domain.dto.input;

import lombok.Data;

import java.util.List;

@Data
public class ReqConsultDto {

    private String diagnose;

    private String symptoms;

    private String comment;

    private Long doctorId;

    private Long patientId;

    private List<Long> medicationIds;
}
