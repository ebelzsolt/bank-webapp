package com.example.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.dao.UserDao;
import com.example.bank.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public boolean checkUserExists(String username, String email) {
		if (isUsernameExits(username) || isEmailExits(email)) {
			return true;
		}

		return false;
	}

	public boolean isUsernameExits(String username) {
		if (findByUsername(username) != null) {
			return true;
		}
		
		return false;
	}

	public boolean isEmailExits(String email) {
		if (findByEmail(email) != null) {
			return true;
		}
		
		return false;
	}
}
