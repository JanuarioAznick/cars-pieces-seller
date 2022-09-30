package com.mycart.carspiecesseller.services;

import java.util.List;

import com.mycart.carspiecesseller.dto.OrderDTO;
import com.mycart.carspiecesseller.entities.Order;
import com.mycart.carspiecesseller.entities.Product;

public interface OrderService {

	List<OrderDTO> findById(Long id);

	List<OrderDTO> findAll();

	Order saveOrder(Order order, Long productId, Long id);

}
