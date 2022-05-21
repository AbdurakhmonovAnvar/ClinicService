package com.example.Exam.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Getter
@Setter

public class DoctorDto {
    private Integer id;

    private Integer experience;
    @NotBlank(message = ("Ismda xatolik"))
    @NotEmpty(message = ("Ism bo`sh bo'lishi mumkin emas"))
    private String name;
    @NotBlank(message = ("Familyada xatolik"))
    @NotEmpty(message = ("Familya bo`sh bo'lishi mumkin emas"))
    private String surname;
    private String direction;
    @NotNull(message = ("Invalid contact"))
    @Size( min = 12, max = 13,  message = ("Agarda ***") )
    private String contact;
    private boolean status;
    private LocalDateTime createdAt;


}
