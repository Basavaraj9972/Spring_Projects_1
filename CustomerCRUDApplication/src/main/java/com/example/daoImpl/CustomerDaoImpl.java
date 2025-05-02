package com.example.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.util.Database;
import com.tap.model.Customer;

public class CustomerDaoImpl {
	private Connection getConnection() throws SQLException {
        return Database.getConnection();
    }

    public void createCustomer(Customer customer) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO customers (first_name, last_name, street, address, city, state, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getStreet());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getCity());
            statement.setString(6, customer.getState());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, Customer customer) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE customers SET first_name = ?, last_name = ?, street = ?, address = ?, city = ?, state = ?, email = ?, phone = ? WHERE id = ?")) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getStreet());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getCity());
            statement.setString(6, customer.getState());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getPhone());
            statement.setInt(9, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("street"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getCustomers(int page, int size, String sortBy, String search) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers WHERE CONCAT(first_name, ' ', last_name, ' ', street, ' ', address, ' ', city, ' ', state, ' ', email, ' ', phone) LIKE ? ORDER BY " + sortBy + " LIMIT ? OFFSET ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + search + "%");
            statement.setInt(2, size);
            statement.setInt(3, (page - 1) * size);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("street"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

}
