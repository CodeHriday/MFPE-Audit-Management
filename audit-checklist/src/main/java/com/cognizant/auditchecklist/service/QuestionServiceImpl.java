package com.cognizant.auditchecklist.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditchecklist.model.AuditType;
import com.cognizant.auditchecklist.model.Question;
import com.cognizant.auditchecklist.repository.QuestionRepo;
/*
 * service class to implement the functions defined in service interface
 */

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	Logger logger = LoggerFactory.getLogger("Audit-Checklist-Question-Service-Logger");
	
	// function to fetch and return audit questions from question repository
	
	public List<Question> getQuestionsByAuditType(AuditType auditType){
		logger.info("Inside  getQuestionsByAuditType function");
		List<Question> ques_list = questionRepo.getQuestionsByAuditType(auditType.getAuditType());
		return ques_list;
	}

}
