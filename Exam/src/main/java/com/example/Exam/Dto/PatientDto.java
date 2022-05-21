package com.example.Exam.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Getter
@Setter
public class PatientDto {


    @NotNull(message = ("Bo'sh bo'lishi mumkin emas"))
    private Integer experience;


    @NotNull(message = ("Familya bo'sh bo'lishi mumkin emas"))
    private String surname;

    private String direction;

    @NotNull(message = ("Invalid birthday"))
    private LocalDateTime birthday;

    @NotNull(message = ("Not null"))
    private String contact;

    private boolean status;

    private LocalDateTime createdAt;



}
