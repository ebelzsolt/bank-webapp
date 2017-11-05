package com.example.bank.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bank.dao.RoleDao;
import com.example.bank.domain.User;
import com.example.bank.domain.security.UserRole;
import com.example.bank.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleDao roleDao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {
		
		String username = user.getUsername();
		String email = user.getEmail();
		
		if (userService.checkUserExists(username, email)) {
			
			if (userService.isUsernameExits(username)) {
				model.addAttribute("usernameExists", true);
			}
			
			if (userService.isEmailExits(email)) {
				model.addAttribute("emailExists", true);
			}
			
			return "signup";
			
		} else {
			
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			
			userService.createUser(user, userRoles);
			
			return "redirect:/home";
		}
		
	}
	
}
