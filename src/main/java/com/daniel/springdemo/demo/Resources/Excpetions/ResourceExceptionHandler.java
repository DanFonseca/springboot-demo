package com.daniel.springdemo.demo.Resources.Excpetions;

import com.daniel.springdemo.demo.Services.Excpetions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //intercpta as excecoes que ocorrerem
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity <StandardError> resourceNotFound
            (ResourceNotFoundException e, HttpServletRequest request){

        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity <StandardError> numberFormatException
            (NumberFormatException e, HttpServletRequest request){

        String error = "Number Format Exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(),error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
