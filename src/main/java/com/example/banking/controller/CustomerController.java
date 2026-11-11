package com.example.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.banking.dto.CustomerDto;
import com.example.banking.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/{id}")
	public CustomerDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/create")
	public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customer) {
		return service.createCustomer(customer);
	}

}
