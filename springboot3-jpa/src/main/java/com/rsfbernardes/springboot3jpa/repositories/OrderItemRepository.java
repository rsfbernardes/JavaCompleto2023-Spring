package com.rsfbernardes.springboot3jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsfbernardes.springboot3jpa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
