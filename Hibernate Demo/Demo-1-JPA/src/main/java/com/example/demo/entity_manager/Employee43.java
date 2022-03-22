package com.example.demo.entity_manager;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee43 {
	
	@Id
	private int id;
	private String name;
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
	public Employee43( String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee43() {
		super();
	}
	@Override
	public String toString() {
		return "Employee43 [id=" + id + ", name=" + name + "]";
	}
	
	

}
