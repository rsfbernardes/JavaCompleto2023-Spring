package com.rsfbernardes.springboot3jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsfbernardes.springboot3jpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
