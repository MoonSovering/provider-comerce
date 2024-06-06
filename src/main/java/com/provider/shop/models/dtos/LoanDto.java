package com.provider.shop.models.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class LoanDto {
    @NotNull(message = "The reader id cannot be null.")
    @NotBlank(message = "The reader id cannot be blank.")
    public String readerId;
    @NotNull(message = "The loan days cannot be null")
    @DecimalMin(value = "0", inclusive = false, message = "The loan days must be greater than 0")
    public Integer loanDays;
    @NotNull(message = "The list of library cannot be null.")
    @NotEmpty(message = "The list of library cannot be empty.")
    public List<UUID> libraryItemIds;
}
