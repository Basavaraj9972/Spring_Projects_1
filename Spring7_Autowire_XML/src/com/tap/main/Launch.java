package com.tap.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		String loc= "/com/tap/config/ApplicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(loc);
		Employee e = (Employee)context.getBean("emp1");
		System.out.print(e);
	}

}
