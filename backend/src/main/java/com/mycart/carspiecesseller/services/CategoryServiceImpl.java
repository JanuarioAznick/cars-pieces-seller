package com.mycart.carspiecesseller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.carspiecesseller.entities.Category;
import com.mycart.carspiecesseller.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category cat) {
		
		return categoryRepository.save(cat);
	}
	
	@Override
	public List<Category> findCategories() {
		
		return categoryRepository.findAll();
	}
	
	@Override
	public Category findById(Long id) {
		
		Optional<Category> cat = categoryRepository.findById(id);
		
		return cat.get();
	}

}
