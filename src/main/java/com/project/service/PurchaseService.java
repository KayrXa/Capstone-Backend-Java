package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Purchase;
import com.project.repo.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepo purchaseRepo;

	public Purchase addPurchase(Purchase purchase) {
		return purchaseRepo.save(purchase);
	}
	
	public List<Purchase> getAllByUsername(String username) {
		return purchaseRepo.findByCreatedby(username);
	}
	
	public Optional<Purchase> getPurchaseById(String pid) {
		return purchaseRepo.findById(pid);
	}

}