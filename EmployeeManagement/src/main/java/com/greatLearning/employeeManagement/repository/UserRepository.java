package com.greatLearning.employeeManagement.repository;

import com.greatLearning.employeeManagement.entity.User;

public interface UserRepository {
	
	public User GetUserByUsername(String Username);

}
