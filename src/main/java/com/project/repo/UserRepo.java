package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, String>{
	
	public User findByUsername(String username);
	
	public boolean existsByUsername(String username);

}