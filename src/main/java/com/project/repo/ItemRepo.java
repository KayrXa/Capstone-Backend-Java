package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, String>{
	

}