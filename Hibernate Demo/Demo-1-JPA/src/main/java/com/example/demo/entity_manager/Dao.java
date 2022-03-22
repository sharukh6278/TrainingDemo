package com.example.demo.entity_manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Transactional
public class Dao {
	
	@PersistenceContext()
	EntityManager entityManager;
	
	public void save(Employee43 employee43) {
		entityManager.persist(employee43);
		//Employee43 e1=new Employee43("srk","srk@gmail.com",99595l,45554f);
		//e1.setId(1);
		//entityManager.persist(e1);
		//employee43.setId(1);
		//employee43.setName("RRRR");
		//entityManager.detach(e1);//entity should not be in persist state wont be saved in db
		//entityManager.remove(e1);//entity should be in persist state wont be saved in db
		System.out.println(entityManager.contains(employee43));
		employee43.setName("tttt");
		entityManager.flush();
		employee43.setName("rrrrr");
		System.out.println("before refresh  : "+employee43);
		entityManager.refresh(employee43);//it will synch obj prop with db
		System.out.println("after refresh  : "+employee43);
		
	}

	public void merge(Employee43 e1) {
		entityManager.merge(e1);
		
		
	}

	public void remove() {
		Question q1 = new Question(101, "what is java");
		Answer ans1 = new Answer(102, "java pgm lang");
		q1.getAnserList().add(ans1);
		//ans1.setQuestion(q1);
		entityManager.persist(q1);
		//entityManager.persist(ans1);
		Question qout = entityManager.find(Question.class, 101);
		System.out.println("ans : ***" + qout);
		
		
	}

}
