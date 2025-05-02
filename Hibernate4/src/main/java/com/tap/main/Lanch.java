package com.tap.main;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.pojo.Employee;
import com.tap.pojo.Project;

public class Lanch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
//		Employee e1 = new Employee(1,"tim");
//		Employee e2 = new Employee(2,"raj");
//		
//		Project p1 = new Project(100,"googleDox");
//		Project p2 = new Project(101,"gooleSlide");
//		
//		ArrayList<Project> list = new ArrayList<Project>();
//		list.add(p1);
//		list.add(p2);
//		
//		e1.setProject(list);
//		e2.setProject(list);
//		session.save(e1);
//		session.save(e2);
//		session.save(p1);
//		session.save(p2);
//		
//		Employee e = session.get(Employee.class, 1);
//		System.out.println(e);
//		List<Project> project = e.getProject();
//		Iterator itr = project.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		Project p = session.get(Project.class, 100);
		System.out.println(p);
		
		List<Employee> e = p.getEmployee();
		System.out.println(e);
		ListIterator<Employee> itr = e.listIterator(e.size());
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
		t.commit();
		
	}

}
