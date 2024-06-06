package com.provider.shop.controllers.advice;

import com.provider.shop.shared.exception.ProviderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProviderControllerAdvice {
    @ExceptionHandler(ProviderException.class)
    public ResponseEntity<String> handleProviderException(ProviderException e){
        return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String errorMessage = e.getMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(RuntimeException e) {
        String errorMessage = e.getMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}