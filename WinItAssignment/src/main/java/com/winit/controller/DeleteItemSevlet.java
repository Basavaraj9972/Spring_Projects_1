package com.winit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winit.daoImp.SalesOrderLineImp;
import com.winit.model.SalesOrderLine;

@WebServlet("/callingSevletdeleteitem")
public class DeleteItemSevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String itemIds = req.getParameter("itemId");
		System.out.println("id"+itemIds);
		HttpSession session = req.getSession();
		List<SalesOrderLine> items = (List<SalesOrderLine>)session.getAttribute("items"); 
		if(itemIds!= null) {
			int itemId = Integer.parseInt(itemIds);
			SalesOrderLineImp salesOrderLineImp = new SalesOrderLineImp();
			salesOrderLineImp.delete(itemId);
			items = salesOrderLineImp.getall();
			session.getAttribute("items");
		}
		RequestDispatcher rd = req.getRequestDispatcher("EditItems.jsp");
		rd.forward(req, resp);
	}
}
