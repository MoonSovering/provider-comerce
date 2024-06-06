package com.provider.shop.models.dtos;

import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public class LoanDto {
    @NotNull(message = "The reader id cannot be null.")
    @NotBlank(message = "The reader id cannot be blank.")
    public String readerId;
    @NotNull(message = "The loan days cannot be null")
    @DecimalMin(value = "0", inclusive = false, message = "The loan days must be greater than 0")
    @DecimalMax(value = "15", message = "The loan days cannot be greater than 15")
    public Integer loanDays;
    @NotNull(message = "The list of library cannot be null.")
    @NotEmpty(message = "The list of library cannot be empty.")
    public List<UUID> libraryItemIds;
}
