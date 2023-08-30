package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Purchase;
import com.project.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
@CrossOrigin
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/summary/add")
	public int addPurchase(@RequestBody Purchase purchase) {
		return purchaseService.addPurchase(purchase).getPid();
	}
	
	@GetMapping("/{name}")
	public List<Purchase> getAllByUsername(@PathVariable String name) {
		return purchaseService.getAllByUsername(name);
	}
	
	@GetMapping("/detail/{pid}")
	public Optional<Purchase> getPurchaseById(@PathVariable String pid){
		return purchaseService.getPurchaseById(pid);
	}
	
}