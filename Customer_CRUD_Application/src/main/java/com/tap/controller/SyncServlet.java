package com.tap.controller;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tap.daoImpl.CustomerDaoImpl;
import com.tap.model.Customer;

@WebServlet("/api/sync")
public class SyncServlet extends HttpServlet {

    private CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Type customerListType = new TypeToken<List<Customer>>(){}.getType();
        List<Customer> remoteCustomers = new Gson().fromJson(new InputStreamReader(req.getInputStream()), customerListType);

        for (Customer customer : remoteCustomers) {
		    if (customerDaoImpl.getCustomer(customer.getId()) != null) {
		    	customerDaoImpl.updateCustomer(customer);
		    } else {
		    	customerDaoImpl.addCustomer(customer);
		    }
		}
		resp.setStatus(HttpServletResponse.SC_OK);
    }
}
