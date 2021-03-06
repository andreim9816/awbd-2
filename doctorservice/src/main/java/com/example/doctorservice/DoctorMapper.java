package com.example.doctorservice;


import com.example.domain.Doctor;
import com.example.domain.dto.DoctorDto;
import com.example.domain.dto.input.ReqDoctorDto;
import com.example.domain.dto.input.update.ReqDoctorUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DoctorMapper {

    DoctorDto toDto(Doctor entity);

    Doctor toEntity(ReqDoctorDto dto);

    Doctor toEntityForCreate(ReqDoctorDto dto);

    Doctor update(ReqDoctorUpdateDto req, @MappingTarget Doctor entity);
}
