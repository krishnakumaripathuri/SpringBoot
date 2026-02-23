package com.tejait.batch15.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.CustomerProductsRequest;
import com.tejait.batch15.exceptions.DataNotFoundException;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.model.Products;
import com.tejait.batch15.repository.CustomerRepository;
import com.tejait.batch15.repository.ProductsRepository;
import com.tejait.batch15.service.CustomerDataService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerDataService {

	CustomerRepository repository;
	ProductsRepository prodRepository;

	@Override
	public Customer saveCustomerPan(Customer customer) {
		if (customer.getPan() != null) {
			customer.getPan().setCust(customer);
		}
		return repository.save(customer);
	}

	@Override
	public Customer mapProductsToCustomer(CustomerProductsRequest request) {
		Customer customer = repository.findById(request.getCustomerId())
				.orElseThrow(() -> new DataNotFoundException("customer not found"));
		List<Products> productslist = prodRepository.findAllById(request.getProdIds());
		customer.getProducts().addAll(productslist); // ASSIGNED MULTIPLE PRODS TO CUSTOMER
		return repository.save(customer);
	}
	@Override
	public Optional<Customer> getByCustomerId(Integer id) {
	return repository.findById(id);
	}

	@Override
	public List<Customer> getAll() {
		return repository.findAll();
	}
}
