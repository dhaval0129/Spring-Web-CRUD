package com.djoshi.crud.service;

import java.util.List;

import com.djoshi.crud.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void save(Customer theCustomer);

	Customer getCustomerById(int theId);

	void deleteById(int theId);
}
