package com.winit.model;

public class SalesOrderLine {
	private int id;
	private int salesOrderId;
	private String itemCode;
	private String itemName;
	private float unitPrice;
	private float qty;
	private float totolPrice;
	
	public SalesOrderLine() {

	}

	public SalesOrderLine(int id, int salesOrderId, String itemCode, String itemName, float unitPrice, float qty,
			float totolPrice) {
		super();
		this.id = id;
		this.salesOrderId = salesOrderId;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.totolPrice = totolPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public float getTotolPrice() {
		return totolPrice;
	}

	public void setTotolPrice(float totolPrice) {
		this.totolPrice = totolPrice;
	}

	@Override
	public String toString() {
		return "SalesOrderLine [id=" + id + ", salesOrderId=" + salesOrderId + ", itemCode=" + itemCode + ", itemName="
				+ itemName + ", unitPrice=" + unitPrice + ", qty=" + qty + ", totolPrice=" + totolPrice + "]";
	}
	
		
	
}
