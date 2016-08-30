package com.sjsu.cmpe282.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sjsu.cmpe282.exception.ServiceException;
import com.sjsu.cmpe282.model.Customer;
import com.sjsu.cmpe282.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(UUID.randomUUID());
		customer.setCreateDate(new Date());
		if (!isValidCreateUserRequest(customer)) {
			throw new ServiceException("Invalid create user request.");
		}

		return iCustomerRepository.createCustomer(customer);
	}

	private boolean isValidCreateUserRequest(Customer customer) {
		boolean isValid = false;
		if (customer != null && !StringUtils.isEmpty(customer.getCustomerId())
				&& !StringUtils.isEmpty(customer.getPassword())) {
			isValid=true;
		}
		System.out.println(">>>>> isValidCreateUserRequest: " + isValid);

		return isValid;
	}

}
