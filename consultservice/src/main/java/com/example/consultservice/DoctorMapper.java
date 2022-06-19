package com.example.consultservice;


import com.example.domain.Doctor;
import com.example.domain.dto.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DoctorMapper {
    Doctor toEntity(DoctorDto dto);
}
