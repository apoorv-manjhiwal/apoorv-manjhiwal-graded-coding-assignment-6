package com.greatLearning.employeeManagement.service;

import java.util.List;

import com.greatLearning.employeeManagement.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void save (Employee employee);
	
	public void deleteById(int id);
	
	public Employee findById(int id);
	

}
