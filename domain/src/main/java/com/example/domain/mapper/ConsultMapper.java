//package com.example.domain.mapper;
//
//
//import com.example.domain.Consult;
//import com.example.domain.dto.ConsultDto;
//import com.example.domain.dto.input.ReqConsultDto;
//
//@Mapper
//public interface ConsultMapper {
//
//    ConsultDto toDto(Consult entity);
//
//    @Mapping(source = "patientId", target = "patient", qualifiedByName = "idToPatient")
//    @Mapping(source = "doctorId", target = "doctor", qualifiedByName = "idToDoctor")
//    @Mapping(source = "medicationIds", target = "medications", qualifiedByName = "idsToMedications")
//    Consult toEntity(ReqConsultDto dto);
//
//    @Mapping(source = "patientId", target = "patient", qualifiedByName = "idToPatient")
//    @Mapping(source = "doctorId", target = "doctor", qualifiedByName = "idToDoctor")
//    @Mapping(source = "medicationIds", target = "medications", qualifiedByName = "idsToMedications")
//    Consult update(ReqConsultDto req, @MappingTarget Consult entity);
//}
