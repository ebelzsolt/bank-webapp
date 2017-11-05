package com.example.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.domain.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {
	
	SavingsAccount findByAccountNumber(int accountNumber);

}
