package com.example.demo.one_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int id;
	private String question;
	@OneToOne(mappedBy = "question")
	@JoinColumn(name="aaaa_id") 
	private Answer anser;
	
	public Question(int id, String question) {
		super();
		this.id = id;
		this.question = question;
		
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answer getAnser() {
		return anser;
	}
	public void setAnser(Answer anser) {
		this.anser = anser;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", anser=" + anser + "]";
	}
	
	

}
