package com.example.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.dto.CustomerDto;
import com.example.banking.entity.CustomerEntity;
import com.example.banking.exception.CustomerNotFoundException;
import com.example.banking.repository.CustomerRepository;
import com.example.banking.service.CustomerService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public CustomerDto getById(Long id) {
		CustomerEntity customerEntity = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		return mapToEntity(customerEntity);
	}

	@Override
	@Transactional
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity(customerDto.getFullName().trim(),
				customerDto.getEmail().trim().toLowerCase());
		CustomerEntity save = repository.save(customerEntity);
		return mapToEntity(save);
	}

	private CustomerDto mapToEntity(CustomerEntity c) {
		return new CustomerDto(c.getCustomerId(), c.getFullName(), c.getEmail(), c.getStatus());
	}

}
