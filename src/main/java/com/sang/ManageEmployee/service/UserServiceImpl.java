package com.sang.ManageEmployee.service;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sang.ManageEmployee.model.User;
import com.sang.ManageEmployee.repository.UserRepository;
import com.sang.ManageEmployee.security.AppConfig;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepo;
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private AppConfig appConfig;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Query query = entityManager.createNativeQuery("SELECT * FROM employee_management_system.user where username=:username ",
				User.class);
		query.setParameter("username", username);
		User u = (User) query.getResultList().get(0);
		
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
				new ArrayList<>());
	}

	@Override
	public void addNewUser(User u) {
		String passwordHash=appConfig.passwordEncoder().encode(u.getPassword());
		u.setPassword(passwordHash);
		userRepo.save(u);
	}
}
