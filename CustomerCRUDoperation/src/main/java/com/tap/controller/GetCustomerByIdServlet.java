package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.CustomerDAO;
import com.tap.model.Customer;

@WebServlet("/protected/getCustomerById")
public class GetCustomerByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long customerId = Long.parseLong(request.getParameter("id"));
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerById(customerId);

        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
    }
}
