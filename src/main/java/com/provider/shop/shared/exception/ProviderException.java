package com.provider.shop.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

public class ProviderException extends RuntimeException{
    private HttpStatus errorCode;
    private String errorMessage;

    public ProviderException(String errorMessage, HttpStatus errorCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static String extractErrorMessage(BindingResult errorResult) {
        return errorResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
    public ProviderException() {
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
