package com.djoshi.crud.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(int id) {
		super("Could not find customer with id: " + id);
	}

}
