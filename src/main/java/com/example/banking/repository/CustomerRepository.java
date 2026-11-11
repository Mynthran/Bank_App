package com.example.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
