package com.example.banking.exception;

import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> notFound(CustomerNotFoundException e) {
		return error(HttpStatus.NOT_FOUND, "CUSTOMER_NOT_FOUND", e.getMessage());
	}
	
	 @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<Map<String, String>> conflict(
	            DataIntegrityViolationException ex) {

	        return error(HttpStatus.CONFLICT,
	                "CONSTRAINT_VIOLATION",
	                "The request violates a database constraint");
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> invalid(
	            MethodArgumentNotValidException ex) {

	        String message = ex.getBindingResult()
	                .getFieldErrors().stream()
	                .findFirst()
	                .map(e -> e.getField() + ": "
	                        + e.getDefaultMessage())
	                .orElse("Invalid request");

	        return error(HttpStatus.BAD_REQUEST,
	                "VALIDATION_ERROR", message);
	    }

	private ResponseEntity<Map<String, String>> error(HttpStatusCode status, String code, String msg) {

		return ResponseEntity.status(status).body(Map.of("code", code, "message", msg));

	}

}
