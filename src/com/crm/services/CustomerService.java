package com.crm.services;

import java.util.List;
import com.crm.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers(int theSortField);
	
	public List<Customer> getCustomers(String value);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deteleCustomer(Customer customer);

	public void deteleCustomer(int id);

}
