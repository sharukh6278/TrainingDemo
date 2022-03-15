package com.example.demo.one_to_may;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int id;
	private String question;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Answer> answers=new ArrayList<Answer>();

	
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

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

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + "]";
	}

	

	/*
	 * public List<Answer> getAnswers() { return answers; } public void
	 * setAnswers(List<Answer> answers) { this.answers = answers; }
	 */

}
