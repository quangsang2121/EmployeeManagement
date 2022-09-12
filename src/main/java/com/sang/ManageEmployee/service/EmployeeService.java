package com.sang.ManageEmployee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sang.ManageEmployee.model.Employee;


public interface EmployeeService{
	public List<Employee> getAllEmployee();
}
