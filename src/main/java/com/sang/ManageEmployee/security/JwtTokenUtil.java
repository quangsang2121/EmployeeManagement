package com.sang.ManageEmployee.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sang.ManageEmployee.Util.Util;
import com.sang.ManageEmployee.config.ConfigParameter;
import com.sang.ManageEmployee.model.Setting;
import com.sang.ManageEmployee.repository.SettingRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	@Autowired
	private SettingRepository settingRepo;
	private static final long serialVersionUID = -2550185165626007488L;

	@Value("${jwt.secret}")
	private String secret;

	//retrieve username from jwt token
	public String getUsernameAndPasswordFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
    //for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate token for user
	public String generateToken(String content) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, content);
	}
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		long UTCdate = System.currentTimeMillis();
		long JwtValidityTime=0;
		Optional<Setting> s=settingRepo.findById(ConfigParameter.JWT_TOKEN_VALIDITY.getKey());
		if(s.isPresent() && s.get().getValue() != null) {
			JwtValidityTime=Long.valueOf(s.get().getValue());
		}
		else {
			JwtValidityTime =(Long)ConfigParameter.JWT_TOKEN_VALIDITY.getDefaultValue();
		}
//		long validityTime=
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(UTCdate))
				.setExpiration(new Date(UTCdate + JwtValidityTime))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	//validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String content = getUsernameAndPasswordFromToken(token);
		String username=Util.getUserName(content);
		String password=Util.getPassword(content);
		return (username.equals(userDetails.getUsername()) && password.equals(userDetails.getPassword()) && !isTokenExpired(token));
	}
}