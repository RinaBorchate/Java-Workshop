package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_new")
public class Address {
	@Id
	@GeneratedValue
	private int id;
	private int pincode;
	private String street;
	private String city;
	private String state;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(int id, int pincode, String street, String city, String state, Customer customer) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.street = street;
		this.city = city;
		this.state = state;
		this.customer = customer;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}
