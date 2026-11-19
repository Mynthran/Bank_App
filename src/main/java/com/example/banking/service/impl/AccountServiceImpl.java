package com.example.banking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.banking.dto.AccountDto;
import com.example.banking.entity.AccountEntity;
import com.example.banking.entity.CustomerEntity;
import com.example.banking.enums.AccountType;
import com.example.banking.enums.CustomerStatus;
import com.example.banking.exception.AccountNotFoundException;
import com.example.banking.exception.CustomerNotActiveException;
import com.example.banking.exception.CustomerNotFoundException;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.CustomerRepository;
import com.example.banking.service.AccountService;
import com.example.banking.util.BankUtil;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;

	public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public AccountDto createAccount(Long customerId, AccountType accountType) {
		if (customerId == null || accountType == null) {
			throw new IllegalArgumentException("Customer ID and account type are required");
		}
		CustomerEntity customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
		if (customer.getStatus() != CustomerStatus.ACTIVE) {
			throw new CustomerNotActiveException(customerId);
		}

		AccountEntity accountEntity = new AccountEntity(BankUtil.generateAccountNumber(), customer, accountType);
		AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
		return BankUtil.mapAccountEntityToDto(savedAccountEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountDto getAccountById(Long accountId) {
		AccountEntity customerAccount = accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException(accountId));
		return BankUtil.mapAccountEntityToDto(customerAccount);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountDto> getAccountsByCustomerId(Long customerId) {
		if (!customerRepository.existsById(customerId)) {
			throw new CustomerNotFoundException(customerId);
		}

		List<AccountEntity> accountEntityList = accountRepository.findByCustomer_CustomerId(customerId);
		List<AccountDto> accountDtoList = new ArrayList<>();
		for (AccountEntity accountEntity : accountEntityList) {
			accountDtoList.add(BankUtil.mapAccountEntityToDto(accountEntity));
		}
		return accountDtoList;
	}

}
