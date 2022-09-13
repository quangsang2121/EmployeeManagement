package com.sang.ManageEmployee.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.sang.ManageEmployee.model.User;

public interface UserService {
	UserDetails loadUserByUsername(String username);
	
	void addNewUser(User u);
}
