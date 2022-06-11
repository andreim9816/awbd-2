//package com.example.domain.mapper;
//
//
//import com.example.domain.Medication;
//
//@Mapper(componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.WARN)
//public interface MedicationMapper {
//
//    MedicationDto toDto(Medication entity);
//
//    Medication toEntity(ReqMedicationDto dto);
//
//    Medication update(ReqMedicationDto req, @MappingTarget Medication entity);
//}