package com.tap.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		String loc = "/com/tap/config/ApplicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(loc);
		Employee e1 = context.getBean(Employee.class);
		Employee e2 = context.getBean(Employee.class);
		System.out.println(e1);
		System.out.print(e2);
		//default it will be the Singleton object will give
	}

}
