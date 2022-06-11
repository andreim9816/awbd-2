//package com.example.domain.mapper;
//
//
//import com.example.domain.Patient;
//
//@Mapper(componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.WARN,
//        uses = MapperQualifier.class)
//public interface PatientMapper {
//
//    PatientDto toDto(Patient entity);
//
//    Patient toEntityForCreate(Long depId, ReqPatientDto dto);
//
//    Patient update(com.example.domain.dto.input.update.ReqPatientUpdateDto req, @MappingTarget Patient entity);
//}
