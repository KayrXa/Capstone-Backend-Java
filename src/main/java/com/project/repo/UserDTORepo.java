package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.UserDTO;

@Repository
public interface UserDTORepo extends CrudRepository<UserDTO, String>{
	
	public UserDTO findByUsername(String username);

}