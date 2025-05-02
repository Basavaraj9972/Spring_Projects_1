package com.modlix.lamda.predefFunctionalInf.ConsumerFunction;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee{
	String name;
	int salary;
	String age;
	
	public Employee(String name, int salary, String age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
}
public class Demo2 {

	public static void main(String[] args) {	
		ArrayList<Employee> arrayList = new ArrayList<Employee>();
		arrayList.add(new Employee("Rakesh",40000,"Male"));
		arrayList.add(new Employee("Rajesj",50000,"Male"));
		arrayList.add(new Employee("Rani",30000,"Female"));
		arrayList.add(new Employee("Jeevan",45000,"Male"));
		arrayList.add(new Employee("Rohan",60000,"Male"));
		
		Function<Employee,Integer> f = e->(e.salary*10)/100;
		Predicate<Integer> p = b->b>=5000;
		Consumer<Employee> c = e->{
			System.out.println(e.name);
			System.out.println(e.salary);
			System.out.println(e.age);
		};  
		
		for(Employee emp : arrayList) {
			int bonus = f.apply(emp);
			if(p.test(bonus)) {
				c.accept(emp);
			}
		}
		
		
	}

}
