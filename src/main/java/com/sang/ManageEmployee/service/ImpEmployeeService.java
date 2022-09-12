package com.sang.ManageEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.ManageEmployee.model.Employee;
import com.sang.ManageEmployee.repository.EmployeeRepository;
@Service
public class ImpEmployeeService implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
