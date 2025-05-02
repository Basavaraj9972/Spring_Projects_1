package com.tap.pojo;

public class Employee {
	private int id;
	private String name;
	private String email;
	private int salary;
	private String address;
	
	public Employee() {
		
	}
	public Employee(int id,String name, String email,int salary,String address) {
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
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
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
