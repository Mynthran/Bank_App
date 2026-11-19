package com.example.banking.exception;

public class CustomerNotActiveException extends RuntimeException {
	
	public CustomerNotActiveException(Long id) {
		super("Customer is not active: " + id);
	}
	
}
