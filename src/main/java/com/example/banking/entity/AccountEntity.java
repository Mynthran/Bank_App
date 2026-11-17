package com.example.banking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.banking.enums.AccountStatus;
import com.example.banking.enums.AccountType;

import jakarta.persistence.*;

@Entity
@Table(name = "BANK_ACCOUNTS")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Long accountId;

	@Column(name = "ACCOUNT_NUMBER", nullable = false, length = 20)
	private String accountNumber;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private CustomerEntity customer;

	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOUNT_TYPE", nullable = false, length = 20)
	private AccountType accountType;

	@Column(name = "POSTED_BALANCE", nullable = false, precision = 19, scale = 2)
	private BigDecimal postedBalance;

	@Column(name = "RESERVED_AMOUNT", nullable = false, precision = 19, scale = 2)
	private BigDecimal reservedAmount;

	@Column(name = "CURRENCY", nullable = false, length = 3)
	private String currency;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false, length = 20)
	private AccountStatus status;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@Column(name = "CREATED_AT", nullable = false, insertable = false, updatable = false)
	private LocalDateTime createdAt;

	
	protected AccountEntity() {

	}

	public AccountEntity(String accountNumber, CustomerEntity customer, AccountType accountType) {

		this.accountNumber = accountNumber;
		this.customer = customer;
		this.accountType = accountType;
		this.postedBalance = new BigDecimal("0.00");
		this.reservedAmount = new BigDecimal("0.00");
		this.currency = "INR";
		this.status = AccountStatus.ACTIVE;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public BigDecimal getPostedBalance() {
		return postedBalance;
	}

	public BigDecimal getReservedAmount() {
		return reservedAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public Long getVersion() {
		return version;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountNumber=" + accountNumber + ", customer=" + customer
				+ ", accountType=" + accountType + ", postedBalance=" + postedBalance + ", reservedAmount="
				+ reservedAmount + ", currency=" + currency + ", status=" + status + ", version=" + version
				+ ", createdAt=" + createdAt + "]";
	}

}
