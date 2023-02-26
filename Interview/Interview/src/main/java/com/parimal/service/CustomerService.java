package com.parimal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.exception.CustomerException;
import com.parimal.model.Customer;

@Service
public interface CustomerService
{
	public Customer registerCustomer(Customer customer);

	public Customer viewCustomer(Integer cId) throws CustomerException;

	public List<Customer> viewAll();

	public Customer updateCustomer(Customer customer, Integer cId) throws CustomerException;

	public Customer deleteCustomer(Integer cid) throws CustomerException;

}
