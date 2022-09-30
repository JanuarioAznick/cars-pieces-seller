package com.mycart.carspiecesseller.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.dto.OrderDTO;
import com.mycart.carspiecesseller.entities.Order;
import com.mycart.carspiecesseller.entities.Product;
import com.mycart.carspiecesseller.entities.User;
import com.mycart.carspiecesseller.entities.enums.OrderStatus;
import com.mycart.carspiecesseller.repositories.OrderRepository;
import com.mycart.carspiecesseller.repositories.ProductRepository;
import com.mycart.carspiecesseller.repositories.UserRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<OrderDTO> findAll() {
		
		List<Order> order =  orderRepository.findAll();
		return order.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Override
	public List<OrderDTO> findById(Long id) {
		
		Optional<Order> order = orderRepository.findById(id);
		return order.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	//@Transactional
	@Override
	public Order saveOrder(Order order, Long productId, Long id) {
		
		Optional<User> user = userRepository.findById(id);
		Optional<Product> product = productRepository.findById(productId);
		
		order.setMoment(Instant.now());
		order.setUserId(user.get());
		order.setOrderStatus(OrderStatus.PANDING);
		order.getProducts().add(product.get());
		
		return orderRepository.save(order);
	}

}
