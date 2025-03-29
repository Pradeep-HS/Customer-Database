package com.customer.service;


import java.util.List;
import java.util.Optional;

import com.customer.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);

	public List<Customer> findAllCustomers();

	public Optional<Customer> findCustomerById(Integer id);

	public void deleteCustomer(Integer id);

	public Customer updateCustomer(Integer customerId, Customer updatedCustomer);


}
