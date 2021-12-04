package com.crm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.CustomerDAO;
import com.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int sort) {
		return customerDAO.getCustomers(sort);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers(String value) {
		return customerDAO.getCustomers(value);
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deteleCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

	@Override
	@Transactional
	public void deteleCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

}
