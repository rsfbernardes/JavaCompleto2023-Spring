package com.rsfbernardes.springboot3jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rsfbernardes.springboot3jpa.entities.User;
import com.rsfbernardes.springboot3jpa.repositories.UserRepository;
import com.rsfbernardes.springboot3jpa.services.exceptions.DatabaseException;
import com.rsfbernardes.springboot3jpa.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		try {
			User userToUpdate = userRepository.getReferenceById(id);
			updateUser(userToUpdate, user);
			return userRepository.save(userToUpdate);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateUser(User userToUpdate, User user) {
		userToUpdate.setName(user.getName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPhone(user.getPhone());
	}
}
