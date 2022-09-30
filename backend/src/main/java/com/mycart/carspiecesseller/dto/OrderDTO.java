package com.mycart.carspiecesseller.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mycart.carspiecesseller.entities.Order;
import com.mycart.carspiecesseller.entities.Product;
import com.mycart.carspiecesseller.entities.enums.OrderStatus;

public class OrderDTO {
	
	private Long id;
	private OrderStatus orderStatus;
	private String address;
	private Instant moment;
	
	private List<ProductDTO> products = new ArrayList<>();
	
	public OrderDTO() {
		
	}

	public OrderDTO(Long id, OrderStatus orderStatus, String address, Instant moment) {
		super();
		this.id = id;
		this.address = address;
		this.orderStatus = orderStatus;
		this.moment = moment;
	}
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		orderStatus = entity.getOrderStatus();
		moment = entity.getMoment();
		address = entity.getAddress();
		products = entity.getProducts().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}
	
	

}
