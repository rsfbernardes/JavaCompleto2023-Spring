package com.rsfbernardes.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rsfbernardes.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
}
