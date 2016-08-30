package com.sjsu.cmpe282.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe282.model.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository {
	
	@Autowired
	private CassandraOperations operations;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer createdCustomer = operations.insert(customer);
		createdCustomer.setPassword("********");
		return createdCustomer;
	
	}

}
