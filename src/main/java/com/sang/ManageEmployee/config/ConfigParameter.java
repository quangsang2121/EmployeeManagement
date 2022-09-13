package com.sang.ManageEmployee.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigParameter {
	JWT_TOKEN_VALIDITY("jwt_token_validity",86400000L);
	private String key;
	private Object defaultValue;
}
