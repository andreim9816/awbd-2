package com.example.patientservice;


import com.example.domain.Patient;
import com.example.domain.dto.PatientDto;
import com.example.domain.dto.input.ReqPatientDto;
import com.example.domain.dto.input.update.ReqPatientUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PatientMapper {

    PatientDto toDto(Patient entity);

    Patient toEntity(ReqPatientDto dto);

    Patient toEntityForCreate(ReqPatientDto dto);

    Patient update(ReqPatientUpdateDto req, @MappingTarget Patient entity);
}
