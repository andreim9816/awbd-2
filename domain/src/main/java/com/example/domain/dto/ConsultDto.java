package com.example.domain.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class ConsultDto extends RepresentationModel<ConsultDto> {

    private Long id;

    private Date date;

    private String diagnose;

    private String symptoms;

    private String comment;
}
