package com.mycart.carspiecesseller.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.dto.ProductDTO;
import com.mycart.carspiecesseller.entities.Category;
import com.mycart.carspiecesseller.entities.Product;
import com.mycart.carspiecesseller.repositories.CategoryRepository;
import com.mycart.carspiecesseller.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	
	@Override
	public Product saveProduct(Product product, Long id) {
		
		Optional<Category> cat = categoryRepository.findById(id);
		
		product.setCreateTime(LocalDateTime.now());
		product.getCategories().add(cat.get());
		
		return productRepository.save(product); 
	}
	
	@Override
	public List<ProductDTO> findProducts(){
		
		List<Product> products = productRepository.findAll();
		
		return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	@Override
	public Product findById(Long id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		return product.get();
	}

}
