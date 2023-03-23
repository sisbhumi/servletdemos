package com.hibernatehelloworld.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="shipping_street")),
		@AttributeOverride(name="City", column=@Column(name="shipping_city")),
		@AttributeOverride(name="pincode", column=@Column(name="shipping_pincode")),
		
	})
	private Address shippingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="billing_street")),
		@AttributeOverride(name="City", column=@Column(name="billing_city")),
		@AttributeOverride(name="pincode", column=@Column(name="billing_pincode")),
		
	})
	private Address billingAddress;
	
	@Embedded
	private Address address;

	public Person(String name, Address address) {
		
		this.name = name;
		this.address = address;
	}

	public Person(String name, Address shipping, Address billing) {
		this.name = name;
		this.billingAddress = billing;
		this.shippingAddress = shipping;
		
	}
	
	
}
