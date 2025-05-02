package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Address;
import com.tap.pojo.Colleguage;
import com.tap.pojo.Employee;

@Configuration
public class Config {
	
	@Bean("add1")
	public Address createObj1() {
		Address a = new Address();
		a.setLaneNum(1);
		a.setCity("Kalaburagi");
		a.setState("Karnataka");
		a.setCountry("India");
		return a;
	}
	
	@Bean("add2")
	public Address createObj2() {
		Address a = new Address();
		a.setLaneNum(2);
		a.setCity("Bengaluru");
		a.setState("Karnata");
		a.setCountry("India");
		return a;
	}
	
	@Bean("col1")
	public Colleguage createObj3() {
		Colleguage c = new Colleguage();
		c.setName1("Raj");
		c.setName2("Rangu");
		c.setName3("Manu");
		c.setName4("Ranga");
		c.setName5("ShivaShankar");
		return c;
	}
	
	@Bean("emp1")
	public Employee createObj4() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Basavaraj");
		e.setEmail("basavarajkalyani976@gmail.com");
		e.setSalary(1009909);
		return e;
	}
	
	
	
}
