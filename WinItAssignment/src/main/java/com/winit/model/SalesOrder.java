package com.winit.model;

import java.time.LocalDateTime;

public class SalesOrder {
	private int id;
	private String salesOrderNumber;
	private String customerCode;
	private String customerName;
	private LocalDateTime orderDate;
	private float totalAmout;
	
	public SalesOrder() {
	}

	public SalesOrder(int id, String salesOrderNumber, String customerCode, String customerName,
			LocalDateTime orderDate, float totalAmout) {
		super();
		this.id = id;
		this.salesOrderNumber = salesOrderNumber;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmout = totalAmout;
	}

	public SalesOrder(int id, String salesOrderNumber, String customerName, LocalDateTime orderDate, float totalAmout) {
		super();
		this.id = id;
		this.salesOrderNumber = salesOrderNumber;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmout = totalAmout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesOrderNumber() {
		return salesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		this.salesOrderNumber = salesOrderNumber;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmout() {
		return totalAmout;
	}

	public void setTotalAmout(float totalAmout) {
		this.totalAmout = totalAmout;
	}

	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", salesOrderNumber=" + salesOrderNumber + ", customerCode=" + customerCode
				+ ", customerName=" + customerName + ", OrderDate=" + orderDate + ", totalAmout=" + totalAmout + "]";
	}
	
	
	
	

}
