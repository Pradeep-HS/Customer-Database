package com.customer.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAllCustomers() {
		// List<Customer> customers = customerRepository.findAll();
		// System.out.println("Fetched Customers: " + customers);
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer updatedCustomer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customerId);

		if (existingCustomer.isPresent()) {
			Customer customer = existingCustomer.get();
			customer.setCustomerName(updatedCustomer.getCustomerName());
			customer.setCustomerEmail(updatedCustomer.getCustomerEmail());
			customer.setCustomerPhoneNumber(updatedCustomer.getCustomerPhoneNumber());
			customer.setCustomerAddress(updatedCustomer.getCustomerAddress());

			return customerRepository.save(customer); // Save and return updated customer
		} else {
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

}
