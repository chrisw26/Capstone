package com.hcl.ecommerce.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
	@NotNull
	private String productName;
	
	@NotNull
	private String productDescription;
	
	@NotNull
	private String productCategory;
	
	

}
