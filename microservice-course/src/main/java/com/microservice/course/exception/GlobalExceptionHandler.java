package com.microservice.course.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> processResourceNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> processDataIntegrityViolation(DataIntegrityViolationException e){
        String message = "Data integrity error. Please ensure the data is not duplicated and is valid.";
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }
}
