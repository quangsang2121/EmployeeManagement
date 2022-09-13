package com.sang.ManageEmployee.service;

import org.springframework.http.ResponseEntity;

import com.sang.ManageEmployee.model.DTO.JsonTokenResponse;
import com.sang.ManageEmployee.model.DTO.JwtRequest;

public interface AuthenticationService {
	ResponseEntity<JsonTokenResponse> authenticate(JwtRequest authenticationRequest) throws Exception;
}
