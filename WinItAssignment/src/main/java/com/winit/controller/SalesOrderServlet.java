package com.winit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winit.daoImp.SalesOrdeImpl;
import com.winit.model.SalesOrder;

@WebServlet("/callingfsvlt")
public class SalesOrderServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SalesOrdeImpl salesOrdeImpl = new SalesOrdeImpl();
		System.out.println("Hello");
		List<SalesOrder> getallSalesOrder = salesOrdeImpl.getall();
		HttpSession session = req.getSession();
		session.setAttribute("getallSalesOrder",getallSalesOrder);
		
		PrintWriter out = resp.getWriter();
		for(SalesOrder so : getallSalesOrder) {
			out.println(so);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("SalesOrderDisplay.jsp");
		rd.forward(req, resp);
	}

}
