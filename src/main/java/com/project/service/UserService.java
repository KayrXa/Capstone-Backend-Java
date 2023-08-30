package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User getUserByName(String username) {
		return userRepo.findByUsername(username);
	}
	
	public boolean validateUser(String name, String password) throws Exception {
		User user = new User();
		try {
			user = getUserByName(name);
		}catch(Exception e) {
			throw new Exception("Invalid credentials.");
		}
		if(user.getUserpassword().equals(password))
			return true;
		else
			throw new Exception("Invalid credentials.");
	}
	
	public User register(User user) throws Exception {
		if (userRepo.existsByUsername(user.getUsername())) {
			throw new Exception("Username already exists.");
		}else {
			return userRepo.save(user);
		}
	}

}