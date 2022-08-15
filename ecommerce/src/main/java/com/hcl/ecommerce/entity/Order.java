package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// private timestamp purchaseDate
	
	private double purchaseAmt;
	
//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private Order order;
//	
//	@ManyToOne
//	@JoinColumn(name="prod_id", nullable=false)
//	private Product product;

}
