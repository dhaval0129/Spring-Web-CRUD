package com.djoshi.crud.rest.dao;

import java.util.List;

import com.djoshi.crud.rest.entity.Customer;

public interface CustomerDao {

	List<Customer> getCustomers();

	void save(Customer theCustomer);

	Customer getCustomerById(int theId);

	void deleteById(int theId);
	
}
