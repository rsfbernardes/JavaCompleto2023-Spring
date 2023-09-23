package com.rsfbernardes.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rsfbernardes.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingAllIgnoringCase(String text);
	
	@Query("{ 'title': {$regex: ?0, $options: 'i'} }")
	List<Post> searchByTitle(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?2} }, "
			+ "{ $or: [ { 'title': {$regex: ?0, $options: 'i'} }, "
			+ "{ 'body': {$regex: ?0, $options: 'i'} }, "
			+ "{ 'comments.text': {$regex: ?0, $options: 'i'} } ] } ] }")
	List<Post> findTextBetweenData(String text, Date startDate, Date endDate);
}
