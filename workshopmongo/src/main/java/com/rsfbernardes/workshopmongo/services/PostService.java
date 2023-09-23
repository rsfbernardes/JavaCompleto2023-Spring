package com.rsfbernardes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsfbernardes.workshopmongo.domain.Post;
import com.rsfbernardes.workshopmongo.repositories.PostRepository;
import com.rsfbernardes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object Not Found!"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingAllIgnoringCase(text);
	}
}
