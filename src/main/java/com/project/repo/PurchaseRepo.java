package com.project.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Purchase;

@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, String>{
	
	public List<Purchase> findByCreatedby(String username);	

}