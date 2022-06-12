package com.example.domain.dto.input.update;

import com.example.domain.dto.input.ReqPersonDto;
import lombok.Data;

import javax.validation.constraints.Pattern;

import static com.example.domain.dto.input.ReqPatientDto.CNP_REGEX;

@Data
public class ReqPatientUpdateDto extends ReqPersonDto {

    //    @NotBlank
    @Pattern(regexp = CNP_REGEX, message = "Invalid CNP!")
    private String cnp;
}
