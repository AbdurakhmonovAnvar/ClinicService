package com.example.Exam.Controller;

import com.example.Exam.Dto.PatientDto;
import com.example.Exam.Service.PatientService;
import com.example.Exam.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
        @PostMapping
        public ResponseEntity<?> create(@RequestBody PatientDto patientDto){
        PatientDto result= patientService.create(patientDto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        PatientDto result = patientService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody PatientDto patientDto){
        PatientDto result = patientService.update(id,patientDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = patientService.delete(id);
        return ResponseEntity.ok(result);
    }
}
