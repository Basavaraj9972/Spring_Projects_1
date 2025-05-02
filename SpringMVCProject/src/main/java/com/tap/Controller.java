package com.tap;

import java.security.Key;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.pojo.Customer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/login")
	public String thirdController(@RequestParam String email,@RequestParam String password,Model model) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		 // Use parameterized query to prevent SQL Injection
        Query<Customer> query = session.createQuery("from Customer e where e.email = :email and e.password = :password", Customer.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        Customer customer = null;
        customer = query.uniqueResult();
        if(customer == null) {
        	return "register";
        }
        else {
        	System.out.print(email+" "+password);
        	return "success";
        }
	}
	
	@RequestMapping("/first")
	public String firstCOntroller(@RequestParam String name,@RequestParam String age,@RequestParam String email,@RequestParam String password,Model model) {
		System.out.print(name+" "+age+" "+email);
//		DatabaseConfigure databaseConfigure = new DatabaseConfigure();
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Customer c = null;
		 Query<Customer> query = session.createQuery("from Customer e where e.email = :email and e.password = :password", Customer.class);
	        query.setParameter("email", email);
	        query.setParameter("password", password);
	        Customer customer = null;
	        customer = query.uniqueResult();
//		int idI = Integer.parseInt(id);
//		c = databaseConfigure.configureDataBase(idI);
//		c = session.get(Customer.class, idI);
		model.addAttribute("name",name);
//		model.addAttribute("id", id);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		if(c==null) {
			 Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//			 String secretKeyBase64 = "0123456789abcdef0123456789abcdef";
		        System.out.print(secretKey);

		        // Generate JWT token
		        String jwtToken = Jwts.builder()
		                .setSubject("Basavaraj") // Example subject (username)
		                .setIssuer("MyApp") // Issuer name
		                .setIssuedAt(new Date()) // Token issued date
		                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Expire in 1 hour
		                .signWith(secretKey) // Signing with the generated secret key
		                .compact();

		        System.out.println("Generated Token: " + jwtToken);
//			int id1 = Integer.parseInt(id);
			int age1 = Integer.parseInt(age);
			c = new Customer(name,age1,email,password);
			session.save(c);
			t.commit();
			return "register";
		}
		else {
			return "failure"; 
		}
	}
	
	@RequestMapping("/nextPage")
    public String nextController(@RequestParam String name,Model model) {
		System.out.print("hello this next page");
		model.addAttribute("name", name);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl("/nextPage");
//        model.addAttribute("name", name);
    
		return "nextPage"; // View name
	}
	
	@RequestMapping("/second")
	public void  SecondContoller() {
		
		System.out.print("hi login success");
		
	}
}
