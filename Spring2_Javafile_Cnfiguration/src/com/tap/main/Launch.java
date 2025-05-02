package com.tap.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFile;
import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
		Employee e = (Employee)context.getBean("emp1");
		System.out.print(e);
		System.out.println();
		Employee e1 = (Employee)context.getBean("emp2");
		System.out.print(e1);
	}
}
