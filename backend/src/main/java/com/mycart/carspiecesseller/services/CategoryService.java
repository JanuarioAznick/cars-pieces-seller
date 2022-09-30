package com.mycart.carspiecesseller.services;

import java.util.List;
import java.util.Optional;

import com.mycart.carspiecesseller.entities.Category;

public interface CategoryService {

	Category saveCategory(Category cat);

	List<Category> findCategories();

	Category findById(Long id);

}
