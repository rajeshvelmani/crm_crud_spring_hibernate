package com.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Customer;
import com.crm.utils.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers(int sort) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// determine sort field
		String theFieldName = null;
		
		switch (sort) {
			case SortUtils.FIRST_NAME: 
				theFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by lastName
				theFieldName = "lastName";
		}
		Query<Customer> query = session.createQuery("from Customer order by "+theFieldName, Customer.class);
		
		return query.getResultList();
		
	}
	
	@Override
	public List<Customer> getCustomers(String searchValue) {
		
		Session session = sessionFactory.getCurrentSession();
		
        //
        // only search by name if theSearchName is not empty
        //
        if (searchValue != null && searchValue.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
        	Query<Customer>  theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + searchValue.toLowerCase() + "%");
            return theQuery.getResultList();
        }        
        return this.getCustomers(-1);
	}


	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}


	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}


	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}


	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

}
