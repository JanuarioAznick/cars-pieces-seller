package com.mycart.carspiecesseller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.carspiecesseller.config.UserPrincipal;
import com.mycart.carspiecesseller.dto.OrderDTO;
import com.mycart.carspiecesseller.entities.Order;
import com.mycart.carspiecesseller.services.OrderService;

@RestController
@RequestMapping("/api/orders")//url padrao da api
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		
		List<OrderDTO> order = orderService.findAll(); 
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<OrderDTO>> findById(@PathVariable Long id){
		
		List<OrderDTO> order = orderService.findById(id);
		return ResponseEntity.ok().body(order);
	}
	
	@PostMapping("save/{id}")
	public ResponseEntity<?> saveOrder(@RequestBody Order order, @PathVariable Long id, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		return new ResponseEntity<>(orderService.saveOrder(order ,id ,userPrincipal.getId()), HttpStatus.CREATED);
	}

}
