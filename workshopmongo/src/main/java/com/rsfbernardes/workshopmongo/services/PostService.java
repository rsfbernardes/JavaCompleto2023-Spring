package com.rsfbernardes.workshopmongo.services;

import java.util.Date;
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
	
	public List<Post> searchByTitle(String text) {
		return postRepository.searchByTitle(text);
	}
	
	public List<Post> searchPostsByTextBetweenDates(String text, Date startDate, Date endDate){
		endDate = new Date(endDate.getTime() + 24 * 60 * 60 * 1000); // 24h in milliseconds
		return postRepository.findTextBetweenData(text, startDate, endDate);
	}
	
}
