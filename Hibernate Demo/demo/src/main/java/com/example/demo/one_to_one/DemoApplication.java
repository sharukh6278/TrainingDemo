package com.example.demo.one_to_one;

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
		Configuration cfg = new Configuration();
		cfg.configure("hbc.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Question q1 = new Question(101, "what is java");

		Answer ans1 = new Answer(102, "java pgm lang");
		q1.setAnser(ans1);
		ans1.setQuestion(q1);
		session.save(q1);
		session.save(ans1);
		Question qout = session.get(Question.class, 101);
		System.out.println("ans : " + qout);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

}
