package com.project.securedocumentvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.securedocumentvault.dto.RegisterRequest;
import com.project.securedocumentvault.service.UserService;
import com.project.securedocumentvault.dto.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public String registerUser(@RequestBody RegisterRequest request) {

	        return userService.registerUser(request);
	    }
	    
	    @PostMapping("/login")
	    public String loginUser(@RequestBody LoginRequest request) {

	        return userService.loginUser(request);
	    }

}
