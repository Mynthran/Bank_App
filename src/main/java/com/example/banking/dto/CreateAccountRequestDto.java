package com.example.banking.dto;

import com.example.banking.enums.AccountType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateAccountRequestDto {
	
	@NotNull(message = "Customer ID is required")
    @Positive(message = "Customer ID must be positive")
    private Long customerId;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

}
