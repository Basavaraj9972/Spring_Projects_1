package com.tap.pojo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class Launch {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
//		Employee e = new Employee(3,"Raj","raj@gmail.com",10000,"IT");
//		session.save(e);
//		Employee e1 = session.get(Employee.class,2);
//		e1.setName("tim");
//		session.update(e1);
//		Employee e2 = session.get(Employee.class,2);
//		session.delete(e2);
//		System.out.print(e2);
		
		Query query = session.createQuery("from Employee e");
		List list = query.getResultList();
		for(Object o:list) {
			System.out.println(o);
		}

//		Query query = session.createQuery("update Employee e set e.salary = e.salary + 5000 where e.salary>=1000");
//		int i = query.executeUpdate();
//		System.out.print(i);
		
//		Employee e = session.get(Employee.class,1);
//		e.setDept("HR");
//		session.update(e);
		
//		Query query = session.createQuery("delete from Employee e where e.dept='HR'");
//		int i = query.executeUpdate();
//		System.out.print(i);
		t.commit();
	}

}
