package com.winit.dao;

import java.util.List;

import com.winit.model.SalesOrder;

public interface SalesOrdeInf {
	public void add(SalesOrder so);
	public SalesOrder get(String customerName);
	public void upadte(SalesOrder so);
	public void delete(int id);
	public List<SalesOrder> getall();
	
	
}
