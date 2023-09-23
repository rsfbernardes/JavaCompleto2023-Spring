package com.rsfbernardes.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsfbernardes.workshopmongo.domain.Post;
import com.rsfbernardes.workshopmongo.resources.util.URL;
import com.rsfbernardes.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titleSearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = postService.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/textSearchBetweenDates")
	public ResponseEntity<List<Post>> findTextBetweenDates(@RequestParam(value = "text", defaultValue = "") String text, 
															@RequestParam(value = "startDate", defaultValue = "") String startDate, 
															@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		text = URL.decodeParam(text);
		Date minDate = URL.convertDate(startDate, new Date(0L));
		Date maxDate = URL.convertDate(endDate, new Date());
		System.out.println(minDate);
		System.out.println(maxDate);
		
		List<Post> posts = postService.searchPostsByTextBetweenDates(text, minDate, maxDate);
		return ResponseEntity.ok().body(posts);
	}
	
}
