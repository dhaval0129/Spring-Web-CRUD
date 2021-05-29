package com.djoshi.crud.dao;

import java.util.List;

import com.djoshi.crud.entity.Customer;

public interface CustomerDao {

	List<Customer> getCustomers();

	void save(Customer theCustomer);

	Customer getCustomerById(int theId);

	void deleteById(int theId);
	
}
