package com.example.medicationservice;

import com.example.domain.Medication;
import com.example.domain.dto.MedicationDto;
import com.example.domain.dto.input.ReqMedicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MedicationMapper {

    MedicationDto toDto(Medication entity);

    Medication toEntity(ReqMedicationDto dto);

    Medication update(ReqMedicationDto req, @MappingTarget Medication entity);
}
