package com.mycart.carspiecesseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycart.carspiecesseller.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
