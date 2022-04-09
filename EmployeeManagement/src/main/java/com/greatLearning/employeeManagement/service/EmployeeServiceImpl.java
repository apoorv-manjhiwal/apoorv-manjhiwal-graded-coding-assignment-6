package com.greatLearning.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() { 
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
		
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);
		
		
	}

	@Override
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);
		
		
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = new Employee();
		
		employee  = employeeRepository.findById(id).get();
		
		return employee;
		
	}

}
