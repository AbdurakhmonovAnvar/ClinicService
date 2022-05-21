package com.example.Exam.model;

import com.example.Exam.Dto.PatientDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("patieent"))
public class Patient extends PatientDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private LocalDateTime birthday;
    private String contact;
    private boolean status;
    private LocalDateTime createdAt;

}
