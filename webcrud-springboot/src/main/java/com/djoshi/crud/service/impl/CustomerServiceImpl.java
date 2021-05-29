package com.djoshi.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djoshi.crud.entity.Customer;
import com.djoshi.crud.repos.CustomerRepository;
import com.djoshi.crud.service.CustomerService;

@Service	
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		return customerRepository.findById(theId).get();
	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}

	
}
