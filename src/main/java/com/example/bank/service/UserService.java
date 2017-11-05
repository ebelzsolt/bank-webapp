package com.example.bank.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bank.dao.RoleDao;
import com.example.bank.dao.UserDao;
import com.example.bank.domain.User;
import com.example.bank.domain.security.UserRole;

@Service
@Transactional
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountService accountService;

	public void save(User user) {
		userDao.save(user);
	}

	public User findByUsername(String username) {
		System.out.println(userDao.findByUsername(username));
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) {
		System.out.println(userDao.findByEmail(email));
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
	
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userDao.findByUsername(user.getUsername());

		if (localUser != null) {
			LOGGER.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);

			for (UserRole ur : userRoles) {
				roleDao.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			
			user.setPrimaryAccount(accountService.createPrimaryAccount());
			user.setSavingsAccount(accountService.createSavingsAccount());
			
			localUser = userDao.save(user);
		}

		return localUser;
	}
}
