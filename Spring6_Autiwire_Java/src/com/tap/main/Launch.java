package com.tap.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.Config;
import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Employee e = context.getBean(Employee.class);
		System.out.print(e);
	}

}
