package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Address;
import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	
	@Bean("add1")
	public Address createAddreesObject() {
		Address a = new Address();
		a.setLaneNum(100);
		a.setCity("Kalaburagi");
		a.setState("Karnataka");
		a.setCountry("India");
		return a;
	}

	
	//This below is Setter method is called
//	@Bean("emp1")
//	public Employee createEmployeeObj() {
//		Employee e = new Employee();
//		e.setId(1);
//		e.setName("Basavaraj");
//		e.setEmail("basavarajkalyani976@gmail.com");
//		e.setSalary(199000);
//		e.setAddress(createAddreesObject());
//		return e;
//	}
	
	///This is below is Constructore method is called
	@Bean("emp1")
	public Employee createEmployeeObj() {
		Employee e = new Employee(1,"Raj","raj@gmail.com",119894,createAddreesObject());
	
		return e;
	}
	
	
}
