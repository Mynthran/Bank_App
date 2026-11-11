package com.example.banking.dto;

import com.example.banking.enums.CustomerStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDto {

	private Long customerId;

	@NotBlank(message = "Full name is required")
	@Size(max = 120)
	private String fullName;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Size(max = 254)
	private String email;

	private CustomerStatus status;

	public CustomerDto() {
	}

	public CustomerDto(Long customerId, String fullName, String email, CustomerStatus status) {
		this.customerId = customerId;
		this.fullName = fullName;
		this.email = email;
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", email=" + email + ", customerStatus"
				+ status + "]";
	}
}
