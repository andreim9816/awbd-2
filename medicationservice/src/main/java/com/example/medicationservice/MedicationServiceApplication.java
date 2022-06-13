package com.example.medicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.example.domain"})
public class MedicationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicationServiceApplication.class, args);
    }

}
