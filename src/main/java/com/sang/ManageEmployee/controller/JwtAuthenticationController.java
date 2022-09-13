package com.sang.ManageEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sang.ManageEmployee.model.DTO.JwtRequest;
import com.sang.ManageEmployee.service.AuthenticationService;

@RestController
@CrossOrigin
@RequestMapping("")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationService authenService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		return authenService.authenticate(authenticationRequest);
	}

}
