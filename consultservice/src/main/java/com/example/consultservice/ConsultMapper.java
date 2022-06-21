package com.example.consultservice;

import com.example.domain.Consult;
import com.example.domain.Doctor;
import com.example.domain.Patient;
import com.example.domain.dto.ConsultDto;
import com.example.domain.dto.DoctorDto;
import com.example.domain.dto.PatientDto;
import com.example.domain.dto.input.ReqConsultDto;
import com.example.domain.dto.input.ReqDoctorDto;
import com.example.domain.dto.input.update.ReqDoctorUpdateDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ConsultMapper {

    ConsultDto toDto(Consult entity);


    Consult toEntity(ReqConsultDto dto);

    Consult update(Consult req, @MappingTarget Consult entity);
}
