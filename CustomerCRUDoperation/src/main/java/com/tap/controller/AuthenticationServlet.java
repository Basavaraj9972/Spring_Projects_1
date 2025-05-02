package com.tap.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.tap.utils.JwtUtil;
@WebServlet("/authenticate")
public class AuthenticationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("login_id");
        String password = request.getParameter("password");
        System.out.println("loginId : "+loginId);
        System.out.println("password : "+password);
        // Perform authentication with external API
        String token = authenticateWithExternalAPI(loginId, password);
        System.out.println("token : "+token);

        if (token != null) {
            // Generate JWT token
            String jwtToken = JwtUtil.generateToken(loginId);
            System.out.println("jwtToken  "+jwtToken);
            // Set token in session or response header for subsequent API calls
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader("Authorization", "Bearer " + jwtToken);
            response.getWriter().write(jwtToken); // Optionally, return token in response
            response.sendRedirect("/protected/getAllCustomers");
        
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private String authenticateWithExternalAPI(String loginId, String password) throws IOException {
        URL url = new URL("https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Prepare JSON body
        String jsonInputString = "{\"login_id\" : \"" + loginId + "\", \"password\" : \"" + password + "\"}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read response
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            String response = br.lines().collect(Collectors.joining(System.lineSeparator()));
            // Parse response to extract token
            System.out.println("resonse "+response);
            return parseTokenFromResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String parseTokenFromResponse(String response) {
        try {
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle error gracefully in your application
        }
    }
}