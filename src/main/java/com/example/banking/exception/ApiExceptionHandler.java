package com.example.banking.exception;

import java.util.Map;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> notFound(CustomerNotFoundException e) {
		return error(HttpStatus.NOT_FOUND, "CUSTOMER_NOT_FOUND", e.getMessage());
	}

	private ResponseEntity<Map<String, String>> error(HttpStatusCode status, String code, String msg) {

		return ResponseEntity.status(status).body(Map.of("code", code, "message", msg));

	}

}
