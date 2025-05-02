package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.pojo.Customer;

public class DatabaseConfigure {
	public static Customer  configureDataBase(int id) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		return session.get(Customer.class, id);
	}
}
