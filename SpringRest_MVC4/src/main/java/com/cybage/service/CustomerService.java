package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.AddressRepository;
import com.cybage.dao.CustomerRepository;
import com.cybage.model.Address;
import com.cybage.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	AddressRepository addressRepository;
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> getCustomer() {
			return customerRepository.findAll();
		}
	public Customer getCustomer(int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	public void updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}
	
	public List<Customer> getCustomerByName(String name){
		return customerRepository.findByName(name);
	}

	public void addAddress(Address address) {
		addressRepository.save(address);
		
	}
}
