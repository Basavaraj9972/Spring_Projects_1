package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.CustomerDAO;
import com.tap.model.Customer;

@WebServlet("/protected/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer data from request parameters
        Customer customer = new Customer();
        customer.setId(Long.parseLong(request.getParameter("id")));
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setStreet(request.getParameter("street"));
        customer.setAddress(request.getParameter("address"));
        customer.setCity(request.getParameter("city"));
        customer.setState(request.getParameter("state"));
        customer.setEmail(request.getParameter("email"));
        customer.setPhone(request.getParameter("phone"));

        // Update customer in database
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.updateCustomer(customer);

        // Redirect to customer list page or show success message
        response.sendRedirect(request.getContextPath() + "/customerList.jsp");
    }
}
