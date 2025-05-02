package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.tap.pojo.Employee;

@Controller
public class ConfigFile {
	
	@Bean
	public Employee emp1() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Basavaraj");
		e.setEmail("basavarajkalyani976@gmail.com");
		e.setSalary(100000);
		e.setAddress("BTM Layout");
		return e;
	}
	
	@Bean("emp2")
	public Employee createObject() {
		Employee e = new Employee(1,"raj","raj@gamil.com",10000,"ram");
		return e;
	}
	
	
}
