//package com.example.domain.mapper;
//
//import com.example.domain.Doctor;
//
//@Mapper(componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.WARN,
//        uses = MapperQualifier.class)
//public interface DoctorMapper {
//
//    com.example.domain.dto.DoctorDto toDto(Doctor entity);
//
//    Doctor toEntity(com.example.domain.dto.input.ReqDoctorDto dto);
//
//    Doctor toEntityForCreate(Long depId, com.example.domain.dto.input.ReqDoctorDto dto);
//
//    Doctor update(ReqDoctorUpdateDto req, @MappingTarget Doctor entity);
//}
