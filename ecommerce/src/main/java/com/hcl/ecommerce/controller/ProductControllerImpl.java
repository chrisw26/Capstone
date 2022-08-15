package com.hcl.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.service.ProductService;

@RestController
public class ProductControllerImpl {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@Valid @RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}
	
	@GetMapping("/getProduct/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}
	
	@PostMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable Long productId, @RequestParam String productName) {
		return productService.updateProduct(productId, productName);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		try {
			productService.deleteProduct(productId);
		} catch (Exception e) {
			return "Failed";
		}
		
		return "Success";
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
}
