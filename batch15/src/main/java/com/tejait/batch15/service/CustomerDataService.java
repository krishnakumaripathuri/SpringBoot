package com.tejait.batch15.service;

import java.util.List;
import java.util.Optional;

import com.tejait.batch15.dto.CustomerProductsRequest;
import com.tejait.batch15.model.Customer;

public interface CustomerDataService {

	Customer saveCustomerPan(Customer customer);

	Customer mapProductsToCustomer(CustomerProductsRequest request);

	Optional<Customer> getByCustomerId(Integer id);

	List<Customer> getAll();

	



}
