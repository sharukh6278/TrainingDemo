package com.example.demo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class User {
	
	@Id
	private String email;
	private String name;
	private String permission;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="email",updatable=false)
	private List<ServiceRecords> listServiceRecords;
	
	public User() {}
	
	public User(String email, String name, String permission, List<ServiceRecords> listServiceRecords) {
		super();
		this.email = email;
		this.name = name;
		this.permission = permission;
		this.listServiceRecords = listServiceRecords;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public List<ServiceRecords> getListServiceRecords() {
		return listServiceRecords;
	}
	public void setListServiceRecords(List<ServiceRecords> listServiceRecords) {
		this.listServiceRecords = listServiceRecords;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", permission=" + permission + ", listServiceRecords="
				+ listServiceRecords + "]";
	}
	
	
	

}
