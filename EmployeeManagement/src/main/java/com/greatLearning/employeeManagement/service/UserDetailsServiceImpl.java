package com.greatLearning.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.repository.UserRepository;
import com.greatLearning.employeeManagement.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.GetUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(" could find user");
		} return new MyUserDetails(user);
	}

}
