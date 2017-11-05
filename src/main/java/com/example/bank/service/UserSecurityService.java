package com.example.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bank.dao.UserDao;
import com.example.bank.domain.User;

@Service
public class UserSecurityService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityService.class); 

	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		if(user == null) {
			LOGGER.warn("username {} not found", username);
			throw new UsernameNotFoundException("Username: " + username + " not found!");
		}
		
		return user;
	}
}
