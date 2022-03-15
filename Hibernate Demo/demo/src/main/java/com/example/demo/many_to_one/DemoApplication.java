package com.example.demo.many_to_one;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*
		 * SpringApplication.run(DemoApplication.class, args); StandardServiceRegistry
		 * ssr = new StandardServiceRegistryBuilder().configure("hbc.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 */
		Configuration cfg = new Configuration();
		cfg.configure("hbc.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Question q1 = new Question(101, "what is java");
		Answer ans1 = new Answer(102, "java pgm lang");
		ans1.setQuestion(q1);

		Answer ans2 = new Answer(103, "java pgm2 lang2");

		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		t.commit();

		Answer qout = session.get(Answer.class, 102);
		System.out.println("ans : " + qout);

		System.out.println("successfully saved");
		//factory.close();
		//session.close();
	}

}
