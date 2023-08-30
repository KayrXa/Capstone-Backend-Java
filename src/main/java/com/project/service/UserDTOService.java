package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.UserDTO;
import com.project.repo.UserDTORepo;

@Service
public class UserDTOService {
	
	@Autowired
	private UserDTORepo userDTORepo;
	
	public Optional<UserDTO> getUserDTOById(String uid) {
		return userDTORepo.findById(uid);
	}
	
	public UserDTO getUserDTOByName(String username) {
		return userDTORepo.findByUsername(username);
	}

}