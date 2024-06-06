package com.provider.shop.controllers.advice;

import com.provider.shop.models.dtos.LoanDto;
import com.provider.shop.services.LoanLibraryService;
import com.provider.shop.shared.exception.ProviderException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanPostController {

    private final LoanLibraryService loan;

    public LoanPostController(LoanLibraryService loan) {
        this.loan = loan;
    }

    @PostMapping("comerce/loan")
    public ResponseEntity<?> requestLoan(@Valid @RequestBody LoanDto body, BindingResult errorResult, HttpServletRequest request){
        if(errorResult.hasErrors()){
            String errorMessage = ProviderException.extractErrorMessage(errorResult);
            throw new ProviderException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(loan.requestLoan(body));
    }
}
