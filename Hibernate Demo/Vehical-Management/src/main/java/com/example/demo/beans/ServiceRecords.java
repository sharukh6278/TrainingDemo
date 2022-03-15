package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServiceRecords {
	
	@Id
	private int id;
	private String email;
	
	private Date serviceDueDate;
	private String status;
	
	private int vehicleNumber;
	public ServiceRecords() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getServiceDueDate() {
		return serviceDueDate;
	}
	public void setServiceDueDate(Date serviceDueDate) {
		this.serviceDueDate = serviceDueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServiceRecords [id=" + id + ", email=" + email + ", serviceDueDate=" + serviceDueDate + ", status="
				+ status + "]";
	}
	
	
	

}
