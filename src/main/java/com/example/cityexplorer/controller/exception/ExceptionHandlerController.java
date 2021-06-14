package com.example.cityexplorer.controller.exception;

import org.hibernate.HibernateException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.function.Function;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<String> handleNotExistEntity(RuntimeException ex) {
        String errMessage = ex.getMessage();
        if (errMessage == null || errMessage.isBlank()) {
            errMessage = "Entity not found";
        }
        return new ResponseEntity<>(errMessage, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<String> handleValidatorException(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getConstraintViolations().stream()
                .map(constraintViolationToErrMessage())
                .collect(Collectors.joining("\n")), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<String> handleHibernateException(HibernateException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    private Function<ConstraintViolation<?>, String> constraintViolationToErrMessage() {
        return constraint -> String.format("%s: %s - %s", constraint.getRootBeanClass().getName(),
                constraint.getPropertyPath().toString(), constraint.getMessage());
    }
}