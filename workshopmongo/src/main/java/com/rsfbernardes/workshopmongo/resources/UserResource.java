package com.rsfbernardes.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rsfbernardes.workshopmongo.domain.Post;
import com.rsfbernardes.workshopmongo.domain.User;
import com.rsfbernardes.workshopmongo.dto.UserDto;
import com.rsfbernardes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> users = userService.findAll();
		List<UserDto> usersDto = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		User user = userService.findById(id);
		UserDto userDto = new UserDto(user);
		return ResponseEntity.ok().body(userDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
		User newUser = userService.fromDto(userDto);
		newUser = userService.insert(newUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDto userDto, @PathVariable String id) {
		User updatedUser = userService.fromDto(userDto);
		updatedUser.setId(id);
		updatedUser = userService.update(updatedUser);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPostsByIdUser(@PathVariable String id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
}
