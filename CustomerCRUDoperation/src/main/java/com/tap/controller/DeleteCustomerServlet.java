package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.CustomerDAO;

@WebServlet("/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long customerId = Long.parseLong(request.getParameter("id"));

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.deleteCustomer(customerId);

        // Redirect to customer list page or show success message
        response.sendRedirect(request.getContextPath() + "/customerList.jsp");
    }
}
