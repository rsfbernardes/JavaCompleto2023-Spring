package com.rsfbernardes.springboot3jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsfbernardes.springboot3jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
