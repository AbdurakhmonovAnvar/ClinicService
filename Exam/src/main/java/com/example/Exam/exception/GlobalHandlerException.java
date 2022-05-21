package com.example.Exam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalHandlerException {
@ExceptionHandler
    public ResponseEntity<?> exception(BadRequest a){
return ResponseEntity.badRequest().body(a.getMessage());
}
}
