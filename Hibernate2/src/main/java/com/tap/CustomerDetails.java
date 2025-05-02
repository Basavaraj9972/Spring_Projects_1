package com.tap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private String Phonenum;
	
	@Column(name="address")
	private String address;
	
	public CustomerDetails() {

	}

	public CustomerDetails(int id, String email, String phonenum, String address) {
		super();
		this.id = id;
		this.email = email;
		Phonenum = phonenum;
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
		return Phonenum;
	}

	public void setPhonenum(String phonenum) {
		Phonenum = phonenum;
	}

	public String getAddres() {
		return address;
	}

	public void setAddres(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return id+" "+email+" "+Phonenum+" "+address;
	}
	
}
