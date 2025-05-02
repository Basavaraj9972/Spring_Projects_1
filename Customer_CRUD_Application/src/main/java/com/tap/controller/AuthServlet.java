package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@WebServlet("/api/authenticate")
public class AuthServlet extends HttpServlet {
    // Hardcoded secret key for simplicity
    private static final String SECRET_KEY = "CQXxQ4tE3KXV+7+SH7RWNgzy4TjFnNMhb+mHu6uhvIw=";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("Received credentials - Username: " + username + ", Password: " + password);

        // Validate username and password
        if ("test@sunbasedata.com".equals(username) && "Test@123".equals(password)) {
            System.out.println("Authentication successful for username: " + username);

            // Generate JWT token
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            String token = JWT.create()
                .withIssuer("auth0")
                .withClaim("username", username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // Token expires in 1 hour
                .sign(algorithm);

            // Return the token in the response
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{ \"token\": \"" + token + "\" }");
            out.flush();
        } else {
            System.out.println("Authentication failed for username: " + username);
            // Authentication failed
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
