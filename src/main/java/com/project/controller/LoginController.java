package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Credentials;
import com.project.entity.User;
import com.project.entity.UserDTO;
import com.project.service.AdminService;
import com.project.service.UserDTOService;
import com.project.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserDTOService userDTOService;
	
	@GetMapping("/profile/{name}")
	public UserDTO getUserByUsername(@PathVariable String name){
		return userDTOService.getUserDTOByName(name);
	}
	
	@PostMapping("/login/admin")
	public void validateAdmin(@RequestBody Credentials admin, HttpSession session) throws Exception{
		if(adminService.validateAdmin(admin.getName(), admin.getPassword())) {
			session.setAttribute("name", admin.getName());
			session.setAttribute("role", "admin");
		}
	}
	
	@PostMapping("/login/user")
	public void validateUser(@RequestBody Credentials user, HttpSession session) throws Exception{
		if(userService.validateUser(user.getName(), user.getPassword())) {
			session.setAttribute("name", user.getName());
			session.setAttribute("role", "user");
		}
	}
	
	@PostMapping("/register")
	public void register(@RequestBody User user) throws Exception {
		userService.register(user);
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("role");
		session.invalidate();
	}

}