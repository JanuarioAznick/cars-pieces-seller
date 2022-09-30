package com.mycart.carspiecesseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycart.carspiecesseller.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
