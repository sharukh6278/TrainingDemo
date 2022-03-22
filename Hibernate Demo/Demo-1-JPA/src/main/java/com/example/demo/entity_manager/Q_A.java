package com.example.demo.entity_manager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="sss")
@Table(name="xxxx")
public class Q_A {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private int q;
	private int a;
	private String email;
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Q_A(int q, int a, String email) {
		super();
		this.q = q;
		this.a = a;
		this.email = email;
	}
	public Q_A() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Q_A [q=" + q + ", a=" + a + ", email=" + email + "]";
	}
	
	

}
