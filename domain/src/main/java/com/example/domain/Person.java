package com.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.example.domain.dto.PersonDto.NAME_REGEX;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class Person {

    @Pattern(regexp = NAME_REGEX, message = "Invalid first name")
    @NotBlank(message = "First name must be provided!")
    private String firstName;

    @Pattern(regexp = NAME_REGEX, message = "Invalid last name")
    @NotBlank(message = "Last name must be provided!")
    private String lastName;
}
