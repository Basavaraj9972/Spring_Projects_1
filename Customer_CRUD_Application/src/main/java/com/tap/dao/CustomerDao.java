package com.tap.dao;
import java.util.List;

import com.tap.model.Customer;
public interface CustomerDao {
	boolean addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	boolean deleteCustomer(int id);
	boolean updateCustomer(Customer customer);
	Customer getCustomer(int id);
	 List<Customer> getAllCustomer(int page, int size, String sortField, String sortOrder, String searchQuery);
}
