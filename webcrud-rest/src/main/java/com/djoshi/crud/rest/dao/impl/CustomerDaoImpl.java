package com.djoshi.crud.rest.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.djoshi.crud.rest.dao.CustomerDao;
import com.djoshi.crud.rest.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Customer> getCustomers() {
		return hibernateTemplate.loadAll(Customer.class);
		
//		// sorted order
//		List<Customer> customers = (List<Customer>) hibernateTemplate
//				.find("from Customer order by firstName");
//		hibernateTemplate.loadAll(Customer.class);
//		return customers;
	}

	@Override
	public void save(Customer theCustomer) {
		hibernateTemplate.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		return (Customer) hibernateTemplate.get(Customer.class, theId);
	}
	
	@Override
	public void deleteById(int theId) {
		Customer customer = hibernateTemplate.get(Customer.class, theId);
		hibernateTemplate.delete(customer);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}

