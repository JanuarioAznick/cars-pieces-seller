package com.mycart.carspiecesseller.services;

import java.util.List;

import com.mycart.carspiecesseller.dto.ProductDTO;
import com.mycart.carspiecesseller.entities.Product;

public interface ProductService {

	List<ProductDTO> findProducts();

	Product saveProduct(Product product, Long id);

	Product findById(Long id);

}
