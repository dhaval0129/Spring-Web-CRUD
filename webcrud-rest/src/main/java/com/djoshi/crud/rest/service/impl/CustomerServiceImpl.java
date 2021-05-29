package com.djoshi.crud.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djoshi.crud.rest.dao.CustomerDao;
import com.djoshi.crud.rest.entity.Customer;
import com.djoshi.crud.rest.service.CustomerService;

@Service	
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		return customerDAO.getCustomerById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

	
}
