package com.example.banking.service;

import java.util.List;

import com.example.banking.dto.AccountDto;
import com.example.banking.enums.AccountType;

public interface AccountService {

	AccountDto createAccount(Long customerId, AccountType accountType);

	AccountDto getAccountById(Long accountId);

	List<AccountDto> getAccountsByCustomerId(Long customerId);
}
