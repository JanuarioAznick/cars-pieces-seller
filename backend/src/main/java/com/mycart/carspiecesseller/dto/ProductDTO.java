package com.mycart.carspiecesseller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mycart.carspiecesseller.entities.Category;
import com.mycart.carspiecesseller.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	private String imageURL;
	private LocalDateTime createTime;
	
	private List<Category> categories = new ArrayList<>();
	
	public ProductDTO() {

	}

	public ProductDTO(Long id, String name, String description, Double price, Integer quantity, String imageURL,
			LocalDateTime createTime) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imageURL = imageURL;
		this.createTime = createTime;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		imageURL = entity.getImageURL();
		createTime = entity.getCreateTime();
		categories = (List<Category>) entity.getCategories();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	
}
