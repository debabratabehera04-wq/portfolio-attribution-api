package com.portfolio.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidInputException.class)

    public ResponseEntity<String> handle(
            InvalidInputException e){

        return ResponseEntity
                .badRequest()
                .body(e.getMessage());

    }
}
