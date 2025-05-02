package com.example.dao;

import java.util.List;

import com.tap.model.Customer;

public interface CustomerDAO {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers(int page, int size, String sortBy, String search);
    void deleteCustomer(Long id);
}
