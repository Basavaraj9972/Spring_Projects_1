package com.tap.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="age")
	private int age;
	
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	public Customer() {

	}
	public Customer(String name, int age, String email,String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	public Customer(int id, String name, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	public Customer(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password
				+ "]";
	}

}
