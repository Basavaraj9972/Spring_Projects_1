package com.tap.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tap.daoImpl.CustomerDaoImpl;
import com.tap.model.Customer;

import io.jsonwebtoken.io.IOException;

@WebServlet("/api/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.io.IOException {
        // Create customer
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            stringBuilder.append(line);
        }
        String requestBody = stringBuilder.toString();
        Customer customer = new Gson().fromJson(requestBody, Customer.class);

        customerDaoImpl.addCustomer(customer);
		resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.io.IOException {
        // Update customer
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            stringBuilder.append(line);
        }
        String requestBody = stringBuilder.toString();
        Customer customer = new Gson().fromJson(requestBody, Customer.class);

        customerDaoImpl.updateCustomer(customer);
		resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        // Get customers
        String id = req.getParameter("id");
        if (id != null) {
            // Get single customer
            try {
                Customer customer = customerDaoImpl.getCustomer(Integer.parseInt(id));
                String json = new Gson().toJson(customer);
                resp.setContentType("application/json");
                resp.getWriter().write(json);
            } catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            String json = new Gson().toJson(customerDaoImpl.getAllCustomer());
			resp.setContentType("application/json");
			resp.getWriter().write(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Delete customer
        String id = req.getParameter("id");
        customerDaoImpl.deleteCustomer(Integer.parseInt(id));
		resp.setStatus(HttpServletResponse.SC_OK);
    }
}
