package com.mvcSpringFashion.DAO;

import java.util.List;

import com.mvcSpringFashion.Model.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	void register(Customer cust,Customer order);
	
	Customer getCustomerByemailId(String emailId);

	Customer getCustomerdetails(int cartId, String emailId);
	
	List<Customer> getOrderdetails();


}
