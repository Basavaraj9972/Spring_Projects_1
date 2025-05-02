package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.utils.AuthUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("login_id");
        String password = req.getParameter("password");

        boolean token = AuthUtils.authenticate(loginId, password);

        if (token) {
            // Store token in session or use it to authenticate further requests
            req.getSession().setAttribute("jwtToken", token);
            resp.sendRedirect("customerList.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=invalid");
        }
    }
}
