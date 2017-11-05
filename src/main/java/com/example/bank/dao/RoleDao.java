package com.example.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
