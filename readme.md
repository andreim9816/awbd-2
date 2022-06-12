# About

Spring Boot project that shows how microservices interact with each other.

# Prerequisites

* Java 11
* Maven 3.8.4

# Technologies

* Spring Boot
* Maven
* Eureka Service
* Spring Cloud Config Server
    * Config server URI -> https://github.com/andreim9816/config-files.git
* Feign Rest Client
* H2 Database
* Mapstruct
* Lombok
* HATEOAS
* Swagger UI
    * DoctorService -> http://localhost:8081/swagger-ui/index.html
    * PatientService -> http://localhost:8082/swagger-ui/index.html

# Build

```
mvn clean install -DskipTests
```

# Entities

* Doctor
* Patient
* Consult
* Medication

# Profiles

All microservices should run with the `dev` profile

# Running

For running the project, first start the `config-server` and `eureka` microservices. Then, you can run the "backend logic" microservices like `patient-service`, `doctor-service` etc in any order you want.
