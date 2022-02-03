package com.cognizant.auditchecklist.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 Entity class to store audit questions in the database.
*/

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AuditQuestions")
public class Question {

	//question id for the questions 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionId")
	private Integer questionId;
	
	
	//auditType for the questions 
	 
	@Column(name="auditType")
	private String auditType;

	
	//questions 

	@Column(name="questions")
	private String question;

	
	//This will be the response for the question

	@Column(name="response")
	private String response;
}
