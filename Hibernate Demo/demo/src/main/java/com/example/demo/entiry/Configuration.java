package com.example.demo.entiry;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value="Configuration") 
public class Configuration extends Employee23 {
	
	@Id
	private int id;
	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Configuration [operation=" + operation + "]";
	}
	
}
