package com.example.demo.entity_manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1JpaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Demo1JpaApplication.class, args);
		
	}

}
