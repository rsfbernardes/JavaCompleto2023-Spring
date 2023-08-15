package com.rsfbernardes.springboot3jpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsfbernardes.springboot3jpa.entities.User;
import com.rsfbernardes.springboot3jpa.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> user = userRepository.findAll();
		return ResponseEntity.ok().body(user);
	}
}
