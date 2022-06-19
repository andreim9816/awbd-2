package com.example.consultservice;


import com.example.domain.Patient;
import com.example.domain.dto.PatientDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PatientMapper {
    Patient toEntity(PatientDto dto);
}
