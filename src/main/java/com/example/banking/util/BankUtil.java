package com.example.banking.util;

import java.util.Locale;
import java.util.UUID;

import com.example.banking.dto.AccountDto;
import com.example.banking.dto.CustomerDto;
import com.example.banking.entity.AccountEntity;
import com.example.banking.entity.CustomerEntity;

public class BankUtil {
	public static CustomerDto mapCustomerEntityToDto(CustomerEntity customerEntity) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customerEntity.getCustomerId());
		customerDto.setEmail(customerEntity.getEmail());
		customerDto.setFullName(customerEntity.getFullName());
		customerDto.setStatus(customerEntity.getStatus());
		return customerDto;
	}

	public static AccountDto mapAccountEntityToDto(AccountEntity accountEntity) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(accountEntity.getAccountId());
		accountDto.setAccountNumber(accountEntity.getAccountNumber());
		accountDto.setAccountType(accountEntity.getAccountType());
		accountDto.setCurrency(accountEntity.getCurrency());
		accountDto.setCreatedAt(accountEntity.getCreatedAt());
		accountDto.setCustomer(mapCustomerEntityToDto(accountEntity.getCustomer()));
		accountDto.setPostedBalance(accountEntity.getPostedBalance());
		accountDto.setReservedAmount(accountEntity.getReservedAmount());
		accountDto.setStatus(accountEntity.getStatus());
		accountDto.setVersion(accountEntity.getVersion());
		return accountDto;
	}
	
	public static String generateAccountNumber() {

        return "ACC" + UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 17)
                .toUpperCase(Locale.ROOT);
    }
}
