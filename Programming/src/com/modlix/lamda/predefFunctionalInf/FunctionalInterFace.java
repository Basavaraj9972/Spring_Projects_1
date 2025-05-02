package com.modlix.lamda.predefFunctionalInf;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee1{
	String name;
	int salary;
	
	public Employee1(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
}
public class FunctionalInterFace {

	public static void main(String[] args) {
		/*
		 * Function<Integer,Integer> fi = n->n*n; System.out.println(fi.apply(2));
		 * System.out.println(fi.apply(5)); System.out.println(fi.apply(8));
		 * 
		 * Function<String,Integer> f1 = s->s.length();
		 * System.out.println(f1.apply("hello")); System.out.println(f1.apply("Good"));
		 * System.out.println(f1.apply("Fine"));
		 */
		
		Function<Employee1,Integer> fi = e->{
						if(e.salary>10000 && e.salary<=20000) {
							return e.salary * 10/100;
						}
						else if(e.salary>20000 && e.salary<=30000) {
							return e.salary * 20/100;
						}
						else if(e.salary>30000 && e.salary<=40000) {
							return e.salary * 30/100; 
						}
						else {
							return e.salary *40/100;
						}
		};
		Predicate<Integer> p = b->b>5000;
		
		ArrayList<Employee1> employees = new ArrayList<Employee1>();
		employees.add(new Employee1("ranga",10000));
		employees.add(new Employee1("ragu",20000));
		employees.add(new Employee1("ramesh",30000));
		employees.add(new Employee1("ramu",40000));
		employees.add(new Employee1("Rjesh",50000));
		
		for(Employee1 employee : employees) {
			int bonus = fi.apply(employee);
			if(p.test(bonus)) {
				System.out.println(employee.name+" "+employee.salary+" "+bonus);
			}
		}
	}

}
