package com.example.banking.dto;

import com.example.banking.enums.CustomerStatus;

public class CustomerDto {

	private Long customerId;
	private String fullName;
	private String email;
	private CustomerStatus status;

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
