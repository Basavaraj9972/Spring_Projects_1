package com.tap.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CustomerDetails")
public class CustomerDetails {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenum")
	private String phonenum;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(mappedBy="customerDetails",cascade=CascadeType.ALL)
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerDetails() {

	}

	public CustomerDetails(int id, String email, String phonenum, String address) {
		super();
		this.id = id;
		this.email = email;
		this.phonenum = phonenum;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", email=" + email + ", phonenum=" + phonenum + ", address=" + address
				+ "]";
	}
	
	
	
}
