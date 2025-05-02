package com.tap.pojo;

public class Employee {
	private String name;
	private String email;
	private int salary;
	private String address;
	public Employee() {
		
	}
	public void Employee(String name,String email,int salary,String address) {
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.address = address;
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
	public String toString() {
		return name+" "+email+" "+salary+" "+address;
	}
}
