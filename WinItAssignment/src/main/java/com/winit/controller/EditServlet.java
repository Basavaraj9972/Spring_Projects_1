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

@WebServlet("/callingSevletEdit")
public class EditServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String ids = req.getParameter("id");
		System.out.print(ids+" id");
		
		int id  = Integer.parseInt(ids);
		SalesOrderLineImp salesOrderLineImp = new SalesOrderLineImp();
		List<SalesOrderLine>  items = null;
		 items = salesOrderLineImp.getallItem(id);
		 for(SalesOrderLine salesOrderLine : items) {
			 System.out.println(salesOrderLine);
		 }
		if(items!=null) {
			session.setAttribute("items",items);
		}
		else {
			session.setAttribute("items","null");
		}
		RequestDispatcher rd = req.getRequestDispatcher("EditItems.jsp");
		rd.forward(req, resp);
		
		
	}

}
