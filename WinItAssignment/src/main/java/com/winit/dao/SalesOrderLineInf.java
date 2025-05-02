package com.winit.dao;

import java.util.List;

import com.winit.model.SalesOrderLine;


public interface SalesOrderLineInf {
	public void add(SalesOrderLine so);
	public SalesOrderLine get(int id);
	public void upadte(SalesOrderLine soi);
	public void delete(int id);
	public List<SalesOrderLine> getall();
	public List<SalesOrderLine> getallItem(int salesOrdeId);

}
