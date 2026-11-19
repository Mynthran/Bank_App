package com.example.banking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.banking.dto.CustomerDto;
import com.example.banking.entity.CustomerEntity;
import com.example.banking.exception.CustomerNotFoundException;
import com.example.banking.repository.CustomerRepository;
import com.example.banking.service.CustomerService;
import com.example.banking.util.BankUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerDto getById(Long id) {
		CustomerEntity customerEntity = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		return BankUtil.mapCustomerEntityToDto(customerEntity);
	}

	@Override
	@Transactional
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity(customerDto.getFullName().trim(),
				customerDto.getEmail().trim().toLowerCase());
		CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
		return BankUtil.mapCustomerEntityToDto(savedCustomerEntity);
	}

}
