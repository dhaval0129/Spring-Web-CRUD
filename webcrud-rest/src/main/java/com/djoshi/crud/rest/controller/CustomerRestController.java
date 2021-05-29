package com.djoshi.crud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djoshi.crud.rest.controller.exception.CustomerNotFoundException;
import com.djoshi.crud.rest.entity.Customer;
import com.djoshi.crud.rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowired the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping(path = "/customers", produces = "application/json")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomerById(customerId);

		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return theCustomer;
	}

	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer theCustomer) {
		customerService.save(theCustomer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		Customer theCustomer = customerService.getCustomerById(id);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}

		customerService.deleteById(id);
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.save(theCustomer);
		return theCustomer;
	}
	
	@PatchMapping("/customers/{id}")
	public void updateCustomerWithPatch(@RequestBody Customer theCustomer, @PathVariable int id) {
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		customerService.save(theCustomer);
	}

}
