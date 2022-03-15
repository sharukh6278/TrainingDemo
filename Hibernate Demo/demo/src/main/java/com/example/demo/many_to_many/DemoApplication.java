package com.example.demo.many_to_many;

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
		Question q2 = new Question(101, "what is python");
		Answer ans1 = new Answer(102, "java pgm lang");
		Answer ans2 = new Answer(103, "java pgm2 lang2");

		Question q3 = new Question(105, "what is java3");
		Question q4 = new Question(106, "what is python4");
		
		ans1.getQuestions().add(q3);
		ans1.getQuestions().add(q4);
		
	
		q1.getAnswers().add(ans1);
		q1.getAnswers().add(ans2);

		
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(q3);
		session.save(q4);
		
		t.commit();

		/*
		 * Question qout = session.get(Question.class, 105);
		 * System.out.println("qout : " + qout);
		 * 
		 * Answer ans = session.get(Answer.class, 102); System.out.println("ans : " +
		 * ans);
		 */
		
		List<Question> users = session.createQuery("From Question").list();
		Question userLazyLoaded = users.get(0);
		System.out.println("userLazyLoaded : "+userLazyLoaded.getAnswers());
		System.out.println("successfully saved");
		//factory.close();
		//session.close();
	}

}
