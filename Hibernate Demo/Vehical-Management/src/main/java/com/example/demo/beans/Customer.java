package com.example.demo.beans;

import java.util.List;

import javax.persistence.Id;

public class Customer {
	
	@Id
	private String email;
	
	private String name;
	
	private long phone;
	
	private String address;
	
	private List<Vehicle> vehicles;

	public Customer() {}
	public Customer(String email, String name, long phone, String address, List<Vehicle> vehicles) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.vehicles = vehicles;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", vehicles=" + vehicles + "]";
	}

	
	

}
