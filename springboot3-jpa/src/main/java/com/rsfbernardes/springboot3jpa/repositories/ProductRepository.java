package com.rsfbernardes.springboot3jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsfbernardes.springboot3jpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
