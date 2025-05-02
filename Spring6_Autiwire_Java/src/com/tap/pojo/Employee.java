package com.tap.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private int id;
	private String name;
	private String email;
	private int salary;
	
	@Autowired
	@Qualifier("add1")
	private Address address;
	
	@Autowired
	private Colleguage colleguage;
	
	public Employee() {

	}

	public Employee(int id, String name, String email, int salary, Address address, Colleguage colleguage) {
		super();
		System.out.print("Constructore method is called");
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.address = address;
		this.colleguage = colleguage;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		System.out.print("Setter method is called");
	}

	public Colleguage getColleguage() {
		return colleguage;
	}

	public void setColleguage(Colleguage colleguage) {
		this.colleguage = colleguage;
		System.out.print("Setter method is called");
	}

	@Override
	public String toString() {
		return id+" "+name+" "+email+" "+salary+" "+address+" "+colleguage;
	}
}
