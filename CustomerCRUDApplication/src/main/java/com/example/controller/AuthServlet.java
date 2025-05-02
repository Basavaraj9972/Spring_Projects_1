//package com.example.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.example.util.JWTUtil;
//
//@WebServlet("/login")
//public class AuthServlet extends HttpServlet {
//    private static final String USERNAME = "test@sunbasedata.com";
//    private static final String PASSWORD = "Test@123";
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String loginId = request.getParameter("login_id");
//        String password = request.getParameter("password");
//
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//
//        if (USERNAME.equals(loginId) && PASSWORD.equals(password)) {
//            String token = JWTUtil.generateToken(loginId);
//            out.print("{\"token\":\"" + token + "\"}");
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            out.print("{\"error\":\"Invalid credentials\"}");
//        }
//        out.flush();
//    }
//}
