package com.example.banking.entity;

import com.example.banking.enums.CustomerStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "BANK_CUSTOMERS")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "FULL_NAME", nullable = false, length = 120)
	private String fullName;

	@Column(name = "EMAIL", nullable = false, length = 254)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private CustomerStatus status;

	public CustomerEntity(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
		this.status = CustomerStatus.ACTIVE;
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
