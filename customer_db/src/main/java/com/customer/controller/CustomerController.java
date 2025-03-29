package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/find-all")
	public List<Customer> findAllCustomers() {
		return customerService.findAllCustomers();
	}

	@GetMapping("/findbyid")
	public Optional<Customer> findCustomerById(@RequestParam Integer id) {
		return customerService.findCustomerById(id);
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestParam Integer customerId, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);
	}

	@DeleteMapping("/delete")
	public String deleteCustomer(@RequestParam Integer id) {
		customerService.deleteCustomer(id);
		return "Customer deleted successfully";
	}
}
