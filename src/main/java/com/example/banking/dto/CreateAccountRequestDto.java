package com.example.banking.dto;

import com.example.banking.enums.AccountType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateAccountRequestDto(

		@NotNull(message = "Customer ID is required") 
		@Positive(message = "Customer ID must be positive") 
		Long customerId,

		@NotNull(message = "Account type is required") 
		AccountType accountType
) {}
