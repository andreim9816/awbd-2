# About

Spring Boot project that shows how microservices interact with each other.

# Technologies:

* Spring Boot
* Maven
* Eureka Service Discovery
* Spring Cloud Config Server
* Feign Rest Client
* H2 Database
* Mapstruct
* Lombok
* HATEOAS
* Swagger UI
    * DoctorService  -> http://localhost:8081/swagger-ui/index.html
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