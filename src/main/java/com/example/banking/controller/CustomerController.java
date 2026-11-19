package com.example.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.CustomerDto;
import com.example.banking.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public CustomerDto getById(@PathVariable Long id) {
		return customerService.getById(id);
	}

	@PostMapping("/create")
	public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customer) {
		return customerService.createCustomer(customer);
	}

}