package com.example.consultservice;

import com.example.domain.dto.MedicationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "medication-service")
public interface MedicationServiceProxy {
    @GetMapping(value = "/medications/{medicationId}", consumes = "application/json")
    MedicationDto findById(@PathVariable Long medicationId);
}
