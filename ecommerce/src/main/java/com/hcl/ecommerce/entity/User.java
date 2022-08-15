package com.hcl.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
//	private Set<Address> addresses;
	
//	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
//	private Address address;
	
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
//	private Set<CreditCard> creditCards;
//	
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
//	private Set<Order> orders;

}
