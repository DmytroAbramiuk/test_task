package com.example.test_task.customer.config;

import com.example.test_task.customer.exception.email.EmailContainsSpacesException;
import com.example.test_task.customer.exception.phone.PhoneContainsSpacesException;
import com.example.test_task.customer.exception.phone.StartsWithPhoneNumberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailContainsSpacesException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(EmailContainsSpacesException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(PhoneContainsSpacesException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(PhoneContainsSpacesException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(StartsWithPhoneNumberException.class)
    public ResponseEntity<AppError> handleEmailContainsSpacesException(StartsWithPhoneNumberException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
}
