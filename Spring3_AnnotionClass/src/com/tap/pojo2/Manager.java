package com.tap.pojo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Manager {
	@Value("21")
	private int id;
	
	@Value("Manoar")
	private String name;
	
	@Value("manohar@gamil.com")
	private String email;
	
	@Value("300000")
	private int salary;
	
	@Value("chandra Layout")
	private String address;
	public Manager() {

	}
	public Manager(int id,String name,String email,int salary,String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.address = address;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public String toString() {
		return id+" "+name+" "+email+" "+salary+" "+address;
	}

}
