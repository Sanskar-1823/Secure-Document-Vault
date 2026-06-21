package com.project.securedocumentvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.securedocumentvault.dto.RegisterRequest;
import com.project.securedocumentvault.entity.User;
import com.project.securedocumentvault.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import com.project.securedocumentvault.dto.LoginRequest;

@Service
public class UserService {
	  @Autowired
	    private UserRepository userRepository;
	  @Autowired
	  private PasswordEncoder passwordEncoder;

	    public String registerUser(RegisterRequest request) {

	        if (userRepository.existsByUsername(request.getUsername())) {
	            return "Username already exists";
	        }

	        if (userRepository.existsByEmail(request.getEmail())) {
	            return "Email already exists";
	        }

	        User user = new User();

	        user.setUsername(request.getUsername());
	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.setRole("USER");

	        userRepository.save(user);

	        return "User Registered Successfully";
	    }
	    
	    
	    public String loginUser(LoginRequest request) {

	        Optional<User> userOptional =
	                userRepository.findByUsername(request.getUsername());

	        if (userOptional.isEmpty()) {
	            return "Invalid Username or Password";
	        }

	        User user = userOptional.get();

	        if (passwordEncoder.matches(
	                request.getPassword(),
	                user.getPassword())) {

	            return "Login Successful";
	        }

	        return "Invalid Username or Password";
	    }
	

}
