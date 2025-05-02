package com.tap.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("1")
	private int id;
	
	@Value("Raj")
	private String name;
	
	@Value("raj@gamil.com")
	private String email;
	
	@Value("100000")
	private int salary;
	
	@Value("Btm Layout")
	private String address;
	public Employee() {

	}
	public Employee(int id,String name,String email,int salary,String address) {
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

