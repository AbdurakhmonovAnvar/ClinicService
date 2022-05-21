package com.example.Exam.Controller;

import com.example.Exam.Dto.VisitDto;
import com.example.Exam.Service.VisitService;
import com.example.Exam.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VisitDto visitDto){
        VisitDto result = visitService.create(visitDto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        VisitDto result = visitService.get(id);
        return ResponseEntity.ok(result);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody VisitDto visitDto){
        boolean result = visitService.update(id,visitDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }
}
