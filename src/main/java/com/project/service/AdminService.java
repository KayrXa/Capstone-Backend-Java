package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admin;
import com.project.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin getAdminByName(String adminname) {
		return adminRepo.findByAdminname(adminname);
	}
	
	public boolean validateAdmin(String name, String password) throws Exception {
		Admin admin = new Admin();
		try {
			admin = getAdminByName(name);
		}catch(Exception e) {
			throw new Exception("Invalid credentials.");
		}
		if(admin.getAdminpassword().equals(password))
			return true;
		else
			throw new Exception("Invalid credentials.");
	}

}