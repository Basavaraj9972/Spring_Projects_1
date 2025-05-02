package com.tap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.pojo.Customer;
import com.tap.pojo.CustomerDetails;
//import com.tap.pojo.Order;
import com.tap.pojo.Order;

public class Launch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(CustomerDetails.class);
		cfg.addAnnotatedClass(Order.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
//		Customer c = new Customer(8,"tim");
//		CustomerDetails cd = new CustomerDetails(109,"tim@gmail.com","6764837844","Benagluru");
//		c.setCustomerDetails(cd);
//		
//		CustomerDetails cd = session.get(CustomerDetails.class, 1);
//		System.out.println(cd);
//		session.delete(cd);
//		session.delete(cd.getCustomer());
		
//		System.out.print(cd.getCustomer());
//		Customer c1 = session.get(Customer.class, 1);
//		System.out.print(c1);
//		session.delete(c1);
//		
//		Order o1 = new Order(506,"Samosa",150);
//		Order o2 = new Order(507,"dosa",200);
//		o1.setCustomer(c);
//		o2.setCustomer(c);
//		session.save(o1);
//		session.save(o2);
//		session.save(c);
//		Customer c = session.get(Customer.class, 2);
//		session.delete(c);
//		System.out.print(c.getCustomerDetails());
//		o1.setCustomer(c);
//		o2.setCustomer(c);
//		session.save(o1);
//		session.save(o2);
		
		Customer c = session.get(Customer.class, 8);
		System.out.print(c);
//		session.delete(c);
		t.commit();
	}

}
