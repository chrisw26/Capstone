package com.hcl.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public synchronized boolean addProduct(Product product) {
		if (getProductByNameAndCategory(product.getName(), product.getCategory()) != null) {
			return false;
		} else {
			productRepository.save(product);
			return true;
		}
	}
	
	@Override
	public Product getProductByNameAndCategory(String name, String category) {
		return productRepository.findByNameAndCategory(name, category);
	}
	
	@Override
	public Product getProductById(Integer productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) return product.get();
		return null;
	}
	
	@Override
	public void updateProduct(Product product) {
		Product prod = getProductById(product.getId());
		prod.setName(product.getName());
		prod.setDescription(product.getDescription());
		prod.setCategory(product.getCategory());
		prod.setPrice(product.getPrice());
		prod.setImage(product.getImage());
		prod.setCount(product.getCount());
		productRepository.save(prod);
	}
	
	@Override
	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

}
