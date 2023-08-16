package com.rsfbernardes.springboot3jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsfbernardes.springboot3jpa.entities.Order;
import com.rsfbernardes.springboot3jpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);  
		return order.get();
	}
}
