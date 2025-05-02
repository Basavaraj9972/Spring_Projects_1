//package com.example.controller;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.example.daoImpl.CustomerDaoImpl;
//import com.tap.model.Customer;
//
//@WebServlet("/api/customers")
//public class CustomerServlet extends HttpServlet {
//    private CustomerDaoImpl customerDAO = new CustomerDaoImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Code to create a customer
//        Customer customer = new Customer(
//                request.getParameter("first_name"),
//                request.getParameter("last_name"),
//                request.getParameter("street"),
//                request.getParameter("address"),
//                request.getParameter("city"),
//                request.getParameter("state"),
//                request.getParameter("email"),
//                request.getParameter("phone")
//        );
//        customerDAO.createCustomer(customer);
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.print("{\"message\":\"Customer created successfully\"}");
//        out.flush();
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Code to update a customer
//        int id = Integer.parseInt(request.getPathInfo().substring(1));
//        Customer customer = new Customer(
//                request.getParameter("first_name"),
//                request.getParameter("last_name"),
//                request.getParameter("street"),
//                request.getParameter("address"),
//                request.getParameter("city"),
//                request.getParameter("state"),
//                request.getParameter("email"),
//                request.getParameter("phone")
//        );
//        customerDAO.updateCustomer(id, customer);
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.print("{\"message\":\"Customer updated successfully\"}");
//        out.flush();
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Code to delete a customer
//        int id = Integer.parseInt(request.getPathInfo().substring(1));
//        customerDAO.deleteCustomer(id);
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        out.print("{\"message\":\"Customer deleted successfully\"}");
//        out.flush();
//    }
//}
