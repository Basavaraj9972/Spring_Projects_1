package com.tap.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.Customer;
import com.tap.CustomerDetails;

public class Launch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(CustomerDetails.class);
		Session session = cfg.buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
//		Customer c = new Customer(2,"cook");
//		CustomerDetails cd = new CustomerDetails(100,"cook@gmail.com","8686645676","BTM");
//		c.setCustomerDetails(cd);
//		session.save(c);
		
//		Customer c = session.get(Customer.class, 1);
//		session.delete(c);
//		System.out.print(c);
		
		
		t.commit();
	}

}
