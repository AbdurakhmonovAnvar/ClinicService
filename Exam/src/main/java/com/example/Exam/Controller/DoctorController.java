package com.example.Exam.Controller;

import com.example.Exam.Dto.DoctorDto;
import com.example.Exam.Service.DoctorService;
import com.example.Exam.Service.PatientService;
import com.example.Exam.Service.VisitService;
import com.example.Exam.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody  @Valid  DoctorDto doctorDto){
        DoctorDto result = doctorService.create(doctorDto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        DoctorDto result = doctorService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody DoctorDto doctorDto){
        boolean  result = doctorService.update(id,doctorDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = doctorService.delete(id);
        return ResponseEntity.ok(result);
    }


}
