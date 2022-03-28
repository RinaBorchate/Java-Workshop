package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="customer_details")
public class Customer {
	
	@Id
	private int id;
	private String name;
	private String emailid;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Address> address1;

	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String emailid, List<Address> address1) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.address1 = address1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	
	public List<Address> getAddress1() {
		return address1;
	}

	public void setAddress1(List<Address> address1) {
		this.address1 = address1;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", emailid=" + emailid + ", address1=" + address1 + "]";
	}

	
	
}
