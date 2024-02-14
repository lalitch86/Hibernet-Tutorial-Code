package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "Question_id")
	private int questionID;
	private String question;
	
	
	//@OneToOne //@JoinColumn(name="a_id")
	//private Answer answer;
	//casacading all will save all inter related data automatically
	@OneToMany(mappedBy = "question",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Answer> answer;

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Question() {
		super();
	}

	public Question(int questionID, String question, List<Answer> answer) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answer = answer;
	}

}
