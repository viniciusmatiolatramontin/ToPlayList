package com.toplaylist.to_play_list.exceptions;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {GameNotFoundException.class})
    public ResponseEntity<Object> handleGameNotFoundException(GameNotFoundException e){
        Error error = new Error(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(value = {DeveloperNotFoundException.class})
    public ResponseEntity<Object> handleDeveloperNotFoundException(DeveloperNotFoundException e){
        Error error = new Error(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(value = {PublisherNotFoundException.class})
    public ResponseEntity<Object> handlePublisherNotFoundException(PublisherNotFoundException e){
        Error error = new Error(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException e){
        Error error = new Error(e.getMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handle(ConstraintViolationException exception) {
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
        Error Error = new Error(errorMessage, HttpStatus.BAD_REQUEST);    
        return new ResponseEntity<Error>(Error, HttpStatus.BAD_REQUEST);
    }
}