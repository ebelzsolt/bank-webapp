package com.example.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.domain.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
	
	PrimaryAccount findByAccountNumber (int accountNumber);

}
