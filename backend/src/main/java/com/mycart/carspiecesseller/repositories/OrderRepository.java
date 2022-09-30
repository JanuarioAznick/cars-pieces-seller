package com.mycart.carspiecesseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycart.carspiecesseller.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
