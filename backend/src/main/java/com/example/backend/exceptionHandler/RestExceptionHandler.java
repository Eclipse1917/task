package com.example.backend.exceptionHandler;

import com.example.backend.response.RestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackages = "com.example.backend.controller")
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handle(MethodArgumentNotValidException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        RestErrorResponse response = new RestErrorResponse();
        response.setCode(status.value());
        response.setMessage("error in field: " + e.getBindingResult().getFieldError().getField() +
                ", error: " + e.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(response, status);
    }
}
