package com.example.domain.dto.input.update;

import com.example.domain.dto.PersonDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.example.domain.dto.input.ReqPatientDto.CNP_REGEX;

@Data
public class ReqPatientUpdateDto extends PersonDto {

    @NotBlank
    @Pattern(regexp = CNP_REGEX, message = "Invalid CNP!")
    private String cnp;
}
