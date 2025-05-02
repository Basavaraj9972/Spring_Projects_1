package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.CustomerDAO;
import com.tap.model.Customer;

@WebServlet("/protected/getAllCustomers")
public class GetAllCustomersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("customers "+customers);
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }
}
