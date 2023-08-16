package com.rsfbernardes.springboot3jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsfbernardes.springboot3jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
