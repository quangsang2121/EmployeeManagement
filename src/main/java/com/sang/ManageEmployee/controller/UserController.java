package com.sang.ManageEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sang.ManageEmployee.model.User;
import com.sang.ManageEmployee.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/user/new")
	public void createAuthenticationToken(@RequestBody User u) {
		userService.addNewUser(u);
	}
}
