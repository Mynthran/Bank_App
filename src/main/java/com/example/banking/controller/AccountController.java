package com.example.banking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.AccountDto;
import com.example.banking.dto.CreateAccountRequestDto;
import com.example.banking.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/create-account")
	public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody CreateAccountRequestDto accountRequestDto) {
		AccountDto savedAccount = accountService.createAccount(accountRequestDto.customerId(),
				accountRequestDto.accountType());

		return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
	}

	@GetMapping("/{accountId}")
	public AccountDto getAccountById(@PathVariable Long accountId) {
		return accountService.getAccountById(accountId);
	}

	@GetMapping("/customer/{customerId}")
	public List<AccountDto> getAccountByCustomerId(@PathVariable Long customerId) {
		return accountService.getAccountsByCustomerId(customerId);
	}
}