package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entiry.Employee23;
import com.example.demo.entiry.Manager;
import com.example.demo.one_to_one.Answer;
import com.example.demo.one_to_one.Question;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication.run(DemoApplication.class, args); StandardServiceRegistry
		 * ssr = new StandardServiceRegistryBuilder().configure("hbc.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 */
		SpringApplication.run(DemoApplication.class, args);
		Configuration cfg = new Configuration();
		cfg.configure("hbc.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Employee23 e = new Employee23(101, "srk", "srk@gmail.com");
		int i=(int) session.save(e);
		System.out.println("i  :"+i);
		Employee23 e2 = new Employee23(i, "srk23", "srk.com");
		session.flush();
		//session.evict(e);
		e.setEmail("3434");
		//session.clear();
		//session.update(e2);
		
		//session.merge(e2);//only this method works
		//session.saveOrUpdate(e2);
		t.commit();  
		

		Employee23 e23 = session.get(Employee23.class, 1);
		
		System.out.println("successfully saved : " + e23);
		
	}

}
