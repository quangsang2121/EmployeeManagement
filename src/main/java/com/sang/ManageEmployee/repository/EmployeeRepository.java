package com.sang.ManageEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.ManageEmployee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
