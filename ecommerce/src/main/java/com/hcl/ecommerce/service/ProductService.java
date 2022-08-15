package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;

public interface ProductService {

	Product addProduct(ProductDto productDto);
	
	Product getProduct(Long productId);
	
	Product updateProduct(Long productId, String productName);

	void deleteProduct(Long productId);

	List<Product> getAllProducts();

}
