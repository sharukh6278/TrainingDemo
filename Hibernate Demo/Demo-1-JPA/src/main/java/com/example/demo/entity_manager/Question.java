package com.example.demo.entity_manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int id;
	private String question;
	@OneToMany
	@JoinTable(name="Q_A",joinColumns = @JoinColumn(name="q"),
	inverseJoinColumns = @JoinColumn(name="a"))
	private List<Answer > anserList=new ArrayList<Answer>();
	
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
	public List<Answer> getAnserList() {
		return anserList;
	}
	public void setAnserList(List<Answer> anserList) {
		this.anserList = anserList;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", anserList=" + anserList + "]";
	}
	
	
	

}
