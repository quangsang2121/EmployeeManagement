package com.sang.ManageEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.ManageEmployee.model.Employee;
import com.sang.ManageEmployee.model.Setting;

public interface SettingRepository extends JpaRepository<Setting, String> {

}
