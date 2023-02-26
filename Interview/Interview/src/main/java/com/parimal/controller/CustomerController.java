package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.CustomerException;
import com.parimal.model.Customer;
import com.parimal.service.CustomerService;

@RestController
public class CustomerController
{
	@Autowired
	private CustomerService cService;

	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer)
	{

		Customer registerCustomer = cService.registerCustomer(customer);

		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.ACCEPTED);

	}

	@GetMapping("/viewall")
	public ResponseEntity<List<Customer>> viewAll()
	{

		List<Customer> allCustomers = cService.viewAll();

		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);

	}

	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<Customer> viewById(@PathVariable("id") Integer id) throws CustomerException
	{

		Customer registerCustomer = cService.viewCustomer(id);

		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> viewById(@PathVariable("id") Integer id, @RequestBody Customer customer)
			throws CustomerException
	{

		Customer registerCustomer = cService.updateCustomer(customer, id);

		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> delteById(@PathVariable("id") Integer id) throws CustomerException
	{

		Customer registerCustomer = cService.deleteCustomer(id);

		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.OK);

	}

}
