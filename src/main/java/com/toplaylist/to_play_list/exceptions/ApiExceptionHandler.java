package com.toplaylist.to_play_list.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
