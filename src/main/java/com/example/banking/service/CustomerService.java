package com.example.banking.service;

import com.example.banking.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto getById(Long id);
	public CustomerDto createCustomer(CustomerDto customerDto);
}
