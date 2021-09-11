package com.bakhtiargalib.inventory.controller;

import com.bakhtiargalib.inventory.exeption.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toMap;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        isNull(exception.getMessage()) ?
                                "Resource not found." : exception.getMessage()
                );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return ResponseEntity.badRequest().body(
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(e -> (FieldError) e)
                        .collect(toMap(FieldError::getField, FieldError::getDefaultMessage))
        );
    }
}
