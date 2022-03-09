package com.example.demo.beans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Component;


@Component
public class Emp {
	private int id;
	private String name;
	
	@Autowired
	//@Qualifier("adress2")
	@Inject
	//@Named("adress2")
	private Adress adress;
	
	/*
	 * public Emp(Adress adress) { this.adress=adress;
	 * System.out.println("emp cons :"+adress); }
	 */
	/*
	 * public Emp(Adress adress) { this.adress=adress;
	 * System.out.println("default emp : "); }
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
		
	public void showAdress() {
		
		this.adress.showAdress();
	}
	
	

}
