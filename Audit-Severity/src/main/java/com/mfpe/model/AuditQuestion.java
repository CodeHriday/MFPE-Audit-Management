package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditQuestion {
	
	//Variable questionId is used to store the QuestionID
	private int questionId;
	
	//Variable question is used to store the Question
	private String question;
	
	//Variable auditType is used to store the Audit Type
	private String auditType;
	
	//Variable response is used to store the Response of the question
	private String response;
	
}