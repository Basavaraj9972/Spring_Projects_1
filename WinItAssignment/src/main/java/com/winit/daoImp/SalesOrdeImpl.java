package com.winit.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.winit.dao.SalesOrdeInf;
import com.winit.model.SalesOrder;

public class SalesOrdeImpl implements SalesOrdeInf{
	static Connection con=null;
	static String INSERT_QUERY ="insert into `salesorder`(`id`,`salesOrderNumber`,`customerName`,`totalAmout`) values(?,?,?,?)";
	static String SELECT_QUERY ="select * from salesorder where `customerName`=?";
	static String UPDATE_QUERY ="update salesorder set `salesOrderNumber`=?,`customerName`=?,`totalAmout`=? where `id`=?";
	static String DELETE_QUERY ="delete from salesorder where `id`=?";
	static String SELECTALL_QUERY ="select * from salesorder";
	
	
	public SalesOrdeImpl() {
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
	public void add(SalesOrder so) {
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1,so.getId());
			pstmt.setString(2,so.getSalesOrderNumber());
			pstmt.setString(3,so.getCustomerName());
			pstmt.setFloat(4,so.getTotalAmout());
			int i = pstmt.executeUpdate();
			System.err.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public SalesOrder get(String customerName) {
		SalesOrder salesOrder = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setString(1,customerName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String salesOrderNumber = rs.getString("salesOrderNumber");
				Timestamp OrderDate = rs.getTimestamp("OrderDate");
				LocalDateTime localDateTime = OrderDate.toLocalDateTime();
				float totalAmout = rs.getFloat("totalAmout");
				salesOrder = new SalesOrder(id,salesOrderNumber,customerName, localDateTime,totalAmout);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesOrder;
	}

	@Override
	public void upadte(SalesOrder so) {
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1,so.getSalesOrderNumber());
			pstmt.setString(2,so.getCustomerName());
			pstmt.setFloat(3,so.getTotalAmout());
			pstmt.setInt(4,so.getId());
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
	public List<SalesOrder> getall() {
		SalesOrder so = null;
		ArrayList<SalesOrder> araryList = new ArrayList<SalesOrder>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL_QUERY);
			while(rs.next()) {
				int id = rs.getInt("id");
				String salesOrderNumber = rs.getString("salesOrderNumber");
				String customerName = rs.getString("customerName");
				Timestamp OrderDate = rs.getTimestamp("OrderDate");
				LocalDateTime localDateTime = OrderDate.toLocalDateTime();
				float totalAmout = rs.getFloat("totalAmout");
				so = new SalesOrder(id,salesOrderNumber,customerName, localDateTime,totalAmout);
				araryList.add(so);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return araryList;
	}
	
}
