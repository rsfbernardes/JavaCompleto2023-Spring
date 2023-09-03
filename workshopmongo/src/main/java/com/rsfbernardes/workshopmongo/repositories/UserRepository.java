package com.rsfbernardes.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rsfbernardes.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
