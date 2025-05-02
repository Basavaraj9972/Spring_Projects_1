package com.winit.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winit.dao.SalesOrderLineInf;
import com.winit.model.SalesOrderLine;

public class SalesOrderLineImp implements SalesOrderLineInf{
	
	static Connection con=null;
	static String INSERT_QUERY ="insert into ``salesorderline``(`id`,`salesOrderId`,`itemCode`,`itemName`,`unitPrice`,`qty`,`totolPrice`) values(?,?,?,?,?,?,?)";
	static String SELECT_QUERY ="select * from salesorderline where `id`=?";
	static String UPDATE_QUERY ="update `salesorderline` set `salesOrderId`=?,`itemCode`=?,`itemName`=? ,`unitPrice`=?,`qty`=?,`totolPrice`=? where `id`=?";
	static String DELETE_QUERY ="delete from `salesorderline` where `id`=?";
	static String SELECTALL_QUERY ="select * from `salesorderline`";
	static String SELECTALL_ITEMS_QUERY ="select * from `salesorderline` where`salesOrderId`=?";
	
	public SalesOrderLineImp() {
		try {
			String url = "jdbc:mysql://localhost:3306/salesordedatabase";
			String username = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loded ");
			con = DriverManager.getConnection(url, username,password);
			System.out.println("Data base connectivity is established");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void add(SalesOrderLine so) {
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1,so.getId());
			pstmt.setInt(2,so.getSalesOrderId());
			pstmt.setString(3,so.getItemCode());
			pstmt.setString(4,so.getItemName());
			pstmt.setFloat(5,so.getUnitPrice());
			pstmt.setFloat(6,so.getQty());
			pstmt.setFloat(7,so.getTotolPrice());
			int i = pstmt.executeUpdate();
			System.err.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SalesOrderLine get(int id) {
		SalesOrderLine salesOrderline = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int salesOrderId = rs.getInt("salesOrderId");
				String itemCode = rs.getString("itemCode");
				String itemName = rs.getString("itemName");
				Float unitPrice = rs.getFloat("unitPrice");
				Float qty = rs.getFloat("qty");
				Float totolPrice = rs.getFloat("totolPrice");
				salesOrderline = new SalesOrderLine(id,salesOrderId,itemCode, itemName,unitPrice,qty,totolPrice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesOrderline;
	
	}

	@Override
	public void upadte(SalesOrderLine so) {
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1,so.getSalesOrderId());
			pstmt.setString(2,so.getItemCode());
			pstmt.setString(3,so.getItemName());
			pstmt.setFloat(4,so.getUnitPrice());
			pstmt.setFloat(5,so.getQty());
			pstmt.setFloat(6,so.getTotolPrice());
			pstmt.setInt(7,so.getId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,id);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<SalesOrderLine> getall() {
		SalesOrderLine salesOrderline = null;
		ArrayList<SalesOrderLine> araryList = new ArrayList<SalesOrderLine>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL_QUERY);
			while(rs.next()) {
				int id = rs.getInt("id");
				int salesOrderId = rs.getInt("salesOrderId");
				String itemCode = rs.getString("itemCode");
				String itemName = rs.getString("itemName");
				Float unitPrice = rs.getFloat("unitPrice");
				Float qty = rs.getFloat("qty");
				Float totolPrice = rs.getFloat("totolPrice");
				salesOrderline = new SalesOrderLine(id,salesOrderId,itemCode, itemName,unitPrice,qty,totolPrice);
				araryList.add(salesOrderline);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return araryList;
	}

	@Override
	public List<SalesOrderLine> getallItem(int salesOrdeId) {
		SalesOrderLine salesOrderline = null;
		ArrayList<SalesOrderLine> araryList = new ArrayList<SalesOrderLine>();
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECTALL_ITEMS_QUERY);
			pstmt.setInt(1, salesOrdeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int salesOrderId = rs.getInt("salesOrderId");
				String itemCode = rs.getString("itemCode");
				String itemName = rs.getString("itemName");
				Float unitPrice = rs.getFloat("unitPrice");
				Float qty = rs.getFloat("qty");
				Float totolPrice = rs.getFloat("totolPrice");
				salesOrderline = new SalesOrderLine(id,salesOrderId,itemCode, itemName,unitPrice,qty,totolPrice);
				araryList.add(salesOrderline);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return araryList;
	}

}
