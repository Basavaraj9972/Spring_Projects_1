package com.tap.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="salary")
	private int salary;
	
	
	@Column(name="dept")
	private String dept;
	
	
	public Employee() {

	}
	
	
	public Employee(int id, String name, String email, int salary, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.dept = dept;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return id+" "+name+" "+email+" "+salary;
	}
	
}
