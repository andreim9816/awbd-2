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

# Kubernetes

In order to deploy the microservices to Kubernetes, you should follow the next steps:

1. Make sure that `spring.config.import` is commented on each `application.properties` from `awbd-2`. The lines should already be commented on if you are on the `kubernetes` branch

2. Comment the `eureka.client.service-url.defaultZone` and `eureka.instance.prefer-ip-address` for each microservice in the `config-files` repository. Also, comment all the lines from the `eurekaserver.properties`. This should also be available on the `kubernetes` branch.

3. Create new Configurations to create Docker images for `configserver`, `eureka` and all the microservices (`doctor`, `patient` etc.) using the following template:

![configuration](./docs/maven_configuration.JPG)

4. Run the configuration, then push the images to the central repository using `docker push <image_name>`

5. Create a cluster on Kubernetes and then connect to it 

6. Using the Google Cloud CLI apply all the images and the configmaps defined under the yaml files in `awbd-2`:
```$shell
kubectl apply configmaps.yml
kubectl apply config_server.yml
kubectl apply doctor.yml
...
```

7. If you need to delete a deployment or/and a service:
```$shell
kubectl delete deployment doctor-deployment
kubectl delete service doctor-service
```
