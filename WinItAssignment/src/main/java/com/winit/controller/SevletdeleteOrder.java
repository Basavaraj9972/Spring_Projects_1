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

import com.winit.daoImp.SalesOrdeImpl;
import com.winit.daoImp.SalesOrderLineImp;
import com.winit.model.SalesOrder;
import com.winit.model.SalesOrderLine;

@WebServlet("/callingSevletdeleteOrder")
public class SevletdeleteOrder extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		HttpSession session = req.getSession();
		List<SalesOrder> getallSalesOrder = (List<SalesOrder>)session.getAttribute("getallSalesOrder");
		if(ids!=null) {
			SalesOrdeImpl salesOrdeImpl = new SalesOrdeImpl();
			int id = Integer.parseInt(ids);
			SalesOrderLineImp salesOrderLineImp = new SalesOrderLineImp();
			salesOrderLineImp.delete(id);
			salesOrdeImpl.delete(id);
			getallSalesOrder = salesOrdeImpl.getall();
			session.getAttribute("getallSalesOrder");
		}
		RequestDispatcher rd = req.getRequestDispatcher("SalesOrderDisplay.jsp");
		rd.forward(req, resp);
	}

}
