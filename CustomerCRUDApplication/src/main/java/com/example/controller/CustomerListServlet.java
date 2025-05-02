//package com.example.controller;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.example.daoImpl.CustomerDaoImpl;
//import com.google.gson.Gson;
//import com.tap.model.Customer;
//
//
//@WebServlet("/api/customers")
//public class CustomerListServlet extends HttpServlet {
//    private CustomerDaoImpl customerDAO = new CustomerDaoImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Code to get the list of customers
//        int page = Integer.parseInt(request.getParameter("page"));
//        int size = Integer.parseInt(request.getParameter("size"));
//        String sortBy = request.getParameter("sortBy");
//        String search = request.getParameter("search");
//
//        List<Customer> customers = customerDAO.getCustomers(page, size, sortBy, search);
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.print(new Gson().toJson(customers));
//        out.flush();
//    }
//}
