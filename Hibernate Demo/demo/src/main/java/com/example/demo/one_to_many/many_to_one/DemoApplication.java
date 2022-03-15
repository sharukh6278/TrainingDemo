package com.example.demo.one_to_many.many_to_one;

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

		Configuration cfg = new Configuration();
		cfg.configure("hbc.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Question q1 = new Question(101, "what is java");
		Question q2 = new Question(101, "what is python");
		Answer ans1 = new Answer(102, "java pgm lang");
		Answer ans2 = new Answer(103, "java pgm2 lang2");

		ans1.getQuestions().add(q1);
		ans1.getQuestions().add(q2);
	
		q1.getAnswers().add(ans1);
		q1.getAnswers().add(ans2);

		
		session.save(q1);
		session.save(ans1);

		t.commit();

		Question qout = session.get(Question.class, 101);
		System.out.println("ans : " + qout);

		System.out.println("successfully saved");
		// factory.close();
		// session.close();
	}

}
