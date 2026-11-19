package com.example.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	Optional<AccountEntity> findByAccountNumber(String accountNumber);
	
	List<AccountEntity> findByCustomer_CustomerId(Long CustomerId);
	
	boolean existsByAccountNumber(String accountNumber);
}
