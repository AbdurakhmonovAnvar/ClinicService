package com.example.Exam.Dto;

import com.example.Exam.model.Doctor;
import com.example.Exam.model.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@Setter
public class VisitDto {
    private Integer id;

    @NotNull(message = ("bo`sh bo`lishi mumkin emas"))
    private Patient patient;

    @NotNull(message = ("patient id berilishi shart"))
    private Integer patient_id;

    @NotNull(message = ("not null"))
    private Doctor doctor;

    @NotNull(message = ("doctor id berilishi shart"))
    private Integer doctor_id;

    @NotNull(message = ("Diagnostika qoyilishi kk"))
    private String diognosis;

    private boolean status;

    private LocalDateTime createdAt;

}
