package com.djoshi.crud.repos;

import org.springframework.data.repository.CrudRepository;

import com.djoshi.crud.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
