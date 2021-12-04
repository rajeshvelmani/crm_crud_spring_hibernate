package com.crm.dao;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(int sort);

	public List<Customer> getCustomers(String value);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

	public void deleteCustomer(int id);
}
