package com.hibernatehelloworld.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	private String city;
	private String pincode;
	
	public Address() {}
	
	public Address(String street, String city, String pincode) {
		
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	
	

}
