package com.example.consultservice;

import com.example.domain.dto.DoctorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "doctor-service")
public interface DoctorServiceProxy {
    @GetMapping(value = "/doctors/{doctorId}", consumes = "application/json")
    DoctorDto findById(@PathVariable Long doctorId);
}