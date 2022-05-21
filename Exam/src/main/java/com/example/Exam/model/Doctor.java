package com.example.Exam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("doctor"))
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer experience;
    private String name;
    private String surname;
    private String direction;

    private String contact;
    private boolean status;
    private LocalDateTime createdAt;



}
