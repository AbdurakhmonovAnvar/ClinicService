package com.example.Exam.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import javax.print.Doc;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("visit"))
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("patient_id"),insertable = false,updatable = false)
    private Patient patient;

    @Column(name = ("patient_id"))
    private Integer patient_id;

    @ManyToOne
    @JoinColumn(name = ("doctor_id"),insertable = false,updatable = false)
    private Doctor doctor;

    @Column(name = ("doctor_id"))
    private Integer doctor_id;

    private String diognosis;

    private boolean status;

    private LocalDateTime createdAt;

}
