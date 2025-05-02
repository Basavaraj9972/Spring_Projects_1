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
@WebServlet("/callingSaveSevletdeleteitem")
public class ItemDelete  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String itemIds = req.getParameter("itemId");
		 HttpSession session = req.getSession();
		 List<SalesOrderLine> itemslist = (List<SalesOrderLine>)session.getAttribute("items");
		 if(itemIds!=null) {
			 int itemId = Integer.parseInt(itemIds);
			 SalesOrderLineImp salesOrderLineImp = new SalesOrderLineImp();
			 salesOrderLineImp.delete(itemId);
			 itemslist = salesOrderLineImp.getall();
			 session.setAttribute("items",itemslist);
		 }
		 RequestDispatcher rd = req.getRequestDispatcher("EditItems.jsp");
		 rd.forward(req, resp);
	}
	
}
