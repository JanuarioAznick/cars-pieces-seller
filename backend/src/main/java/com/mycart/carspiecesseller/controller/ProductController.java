package com.mycart.carspiecesseller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.carspiecesseller.dto.ProductDTO;
import com.mycart.carspiecesseller.entities.Product;
import com.mycart.carspiecesseller.services.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("save/{catId}") //api/product/save/{id}
	public ResponseEntity<?> saveProduct (@RequestBody Product product, @PathVariable Long catId){
		return  new ResponseEntity<>(productService.saveProduct(product, catId), HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findProducts(){
		
		List<ProductDTO> product = productService.findProducts();
		
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Product product = productService.findById(id);
		
		return ResponseEntity.ok().body(product);
	}

}
