package com.example.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSULT_ID")
    private Long id;

    private Date date = new Date();

    private String diagnose;

    private String symptoms;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "FK_DOCTOR_ID")
    @ToString.Exclude
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "FK_PATIENT_ID")
    @ToString.Exclude
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "PRESCRIPTION",
            joinColumns = @JoinColumn(name = "CONSULT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MEDICATION_ID"))
    @ToString.Exclude
    private List<Medication> medications;
}
