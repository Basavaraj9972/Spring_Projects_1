package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Customer;

public class CustomerDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/customer_task3";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (firstName, lastName, street, address, city, state, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE customers SET first_name=?, last_name=?, street=?, address=?, city=?, state=?, email=?, phone=? WHERE id=?";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customers WHERE id=?";
    private static final String SELECT_CUSTOMER_BY_ID_SQL = "SELECT * FROM customers WHERE id=?";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM customers";
    
    public CustomerDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getStreet());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getCity());
            stmt.setString(6, customer.getState());
            stmt.setString(7, customer.getEmail());
            stmt.setString(8, customer.getPhone());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER_SQL)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getStreet());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getCity());
            stmt.setString(6, customer.getState());
            stmt.setString(7, customer.getEmail());
            stmt.setString(8, customer.getPhone());
            stmt.setLong(9, customer.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setStreet(rs.getString("street"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));

                customers.add(customer);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerById(Long id) {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_CUSTOMER_BY_ID_SQL)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setFirstName(rs.getString("firstName"));
                    customer.setLastName(rs.getString("lastName"));
                    customer.setStreet(rs.getString("street"));
                    customer.setAddress(rs.getString("address"));
                    customer.setCity(rs.getString("city"));
                    customer.setState(rs.getString("state"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteCustomer(Long id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(DELETE_CUSTOMER_SQL)) {

            stmt.setLong(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String street;
//    private String address;
//    private String city;
//    private String state;
//    private String email;
//    private String phone;