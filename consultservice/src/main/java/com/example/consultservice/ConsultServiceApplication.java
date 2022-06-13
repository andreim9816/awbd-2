package com.example.consultservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.example.domain"})
public class ConsultServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultServiceApplication.class, args);
    }

}
