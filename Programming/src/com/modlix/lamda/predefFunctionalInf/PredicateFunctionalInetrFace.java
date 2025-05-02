package com.modlix.lamda.predefFunctionalInf;

import java.util.ArrayList;
import java.util.function.Predicate;

class Employee{
	String name;
	int salary;
	int experience;
	
	public Employee(String name, int salary, int experience) {
		super();
		this.name = name;
		this.salary = salary;
		this.experience = experience;
	}
	
}
public class PredicateFunctionalInetrFace {

	public static void main(String[] args) {
		//checking integer is greater than 10 This is the predicate IterFace
//		Predicate<Integer> p = i->(i>10);
//		System.out.println(p.test(20));
//		System.out.println(p.test(9));
//		
//		Predicate<String> ps = s->(s.length()>5);
//		System.out.println(ps.test("Hello How are you"));
//		System.out.println(ps.test("Hello"));
//		
//		String names[] = {"raghavendra", "hari Hara","Ramu","Mahesh","kiran"};
//		for(String name : names) {
//			if(ps.test(name)) {
//				System.out.println(name);
//			}
//			if(name.length()>4) {
//				System.out.println("name : "+name);
//			}
//		}
		
//		Employee employee = new Employee("Ramu",40000,4);
//		
//		Predicate<Employee> pe = e->(e.salary>30000 && e.experience>3);
//		System.out.println(pe.test(employee));
//		
		 ArrayList<Employee> emp = new ArrayList<Employee>();
		 emp.add(new Employee("Ramesh",40000,4));
		 emp.add(new Employee("Ramu",30000,3));
		 emp.add(new Employee("Raghu",50000,4));
		 emp.add(new Employee("Rohan",60000,5));
		 
		 Predicate<Employee> pe = e->(e.salary>30000 && e.experience>3);
//		 System.out.println(pe.test(employee));
			
		 for(Employee e1 : emp) {
			 if(pe.test(e1)) {
				System.out.println(e1.name+" "+ e1.salary+" "+e1.salary); 
			 }
		 }
	}

}
