package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repo.ItemRepo;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepo itemRepo;

	

}