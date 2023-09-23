package com.rsfbernardes.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rsfbernardes.workshopmongo.domain.Post;
import java.util.List;


public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingAllIgnoringCase(String text);
	
}
