package com.djoshi.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djoshi.crud.entity.Customer;
import com.djoshi.crud.exception.CustomerNotFoundException;
import com.djoshi.crud.repos.CustomerRepository;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/list")
	public List<Customer> listCustomer() {

		List<Customer> customer = (List<Customer>) customerRepository.findAll();
		return customer;
	}

	@PostMapping("/list")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {

		customerRepository.save(customer);
		return ResponseEntity.ok("resource created");
	}

	@GetMapping("/list/{id}")
	public Customer listCustomerById(@PathVariable int id) {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		return customer;
	}

	@PutMapping("/list/{id}")
	public Customer updateCustomerById(@RequestBody Customer newCustomer, @PathVariable int id) {

		return customerRepository.findById(id).map(customer -> {
			customer.setFirstName(newCustomer.getFirstName());
			customer.setLastName(newCustomer.getLastName());
			customer.setEmail(newCustomer.getEmail());
			return customerRepository.save(customer);
		}).orElseGet(() -> {
			newCustomer.setId(id);
			return customerRepository.save(newCustomer);
		});
	}

	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable int id) {

		customerRepository.deleteById(id);
		return ResponseEntity.ok("resource deleted");
	}

}
