package com.tap.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orderstable")
public class Order {
	
	@Id
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="item")
	private String item;
	
	@Column(name="price")
	private int price;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="cust_id")
	private Customer customer;
	public Order() {

	}

	public Order(int orderId, String item, int price) {
		super();
		this.orderId = orderId;
		this.item = item;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", item=" + item + ", price=" + price + "]";
	}
	
	
	
}
