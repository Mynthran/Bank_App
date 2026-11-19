package com.example.banking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.banking.entity.CustomerEntity;
import com.example.banking.enums.AccountStatus;
import com.example.banking.enums.AccountType;

public class AccountDto {

	private Long accountId;

	private String accountNumber;

	private CustomerDto customer;

	private AccountType accountType;

	private BigDecimal postedBalance;

	private BigDecimal reservedAmount;

	private String currency;

	private AccountStatus status;

	private Long version;

	private LocalDateTime createdAt;

	public AccountDto() {
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public CustomerDto getCustomer() {
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

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setPostedBalance(BigDecimal postedBalance) {
		this.postedBalance = postedBalance;
	}

	public void setReservedAmount(BigDecimal reservedAmount) {
		this.reservedAmount = reservedAmount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountNumber=" + accountNumber + ", customer=" + customer
				+ ", accountType=" + accountType + ", postedBalance=" + postedBalance + ", reservedAmount="
				+ reservedAmount + ", currency=" + currency + ", status=" + status + ", version=" + version
				+ ", createdAt=" + createdAt + "]";
	}

}
