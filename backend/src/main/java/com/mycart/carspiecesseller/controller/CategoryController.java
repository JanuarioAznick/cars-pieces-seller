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

import com.mycart.carspiecesseller.entities.Category;
import com.mycart.carspiecesseller.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("save")
	public ResponseEntity<?> saveCategory(@RequestBody Category cat){
		
		return new ResponseEntity<>(categoryService.saveCategory(cat), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findCategory(){
		
		List<Category> cat = categoryService.findCategories();
		
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category cat = categoryService.findById(id);
		
		return ResponseEntity.ok().body(cat);
	}
	
	

}
