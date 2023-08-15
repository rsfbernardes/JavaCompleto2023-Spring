package com.rsfbernardes.springboot3jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsfbernardes.springboot3jpa.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {		

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Maria", "maria@gmail.com", "999991234", "12345");
		return ResponseEntity.ok().body(user);
	}
}
