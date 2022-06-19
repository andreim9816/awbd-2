package com.example.consultservice;

import com.example.domain.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "patient-service")
public interface PatientServiceProxy {
    @GetMapping(value = "/patients/{patientId}", consumes = "application/json")
    PatientDto findById(@PathVariable Long patientId);
}