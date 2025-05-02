package com.tap.pojo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_Cookie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Cookie cookie1 = new Cookie("name",name);
		Cookie cookie2 = new Cookie("password",password);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		RequestDispatcher rd = req.getRequestDispatcher("getCookie");
		rd.forward(req, resp);
	}
}
