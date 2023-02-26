package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CustomerException;
import com.parimal.model.Customer;
import com.parimal.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepo cRepo;

	@Override
	public Customer registerCustomer(Customer customer)
	{
		return cRepo.save(customer);

	}

	@Override
	public Customer viewCustomer(Integer cId) throws CustomerException
	{
		return cRepo.findById(cId).orElseThrow(() -> new CustomerException("Customer Not Found"));

	}

	@Override
	public List<Customer> viewAll()
	{

		return cRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer cId) throws CustomerException
	{

		Customer existcustomer = cRepo.findById(cId).orElseThrow(() -> new CustomerException("Customer Not Found"));
		existcustomer.setCName(customer.getCName());
		existcustomer.setMobile(customer.getMobile());

		return cRepo.save(existcustomer);

	}

	@Override
	public Customer deleteCustomer(Integer cid) throws CustomerException
	{
		Customer existcustomer = cRepo.findById(cid).orElseThrow(() -> new CustomerException("Customer Not Found"));

		cRepo.delete(existcustomer);

		return existcustomer;
	}

}
