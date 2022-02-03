package com.cognizant.auditchecklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditchecklist.model.Question;
import com.cognizant.auditchecklist.service.QuestionService;
import com.cognizant.auditchecklist.model.AuditType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/checklist")
@CrossOrigin(origins = "*")
public class AuditCheckListController {
	
	@Autowired
	private QuestionService questionService;
	
	Logger logger = LoggerFactory.getLogger("Audit-Checklist-Controller-Logger");
	
	
	// Endpoint to check if the checklist microservice is active 
	
		@GetMapping("/health-check")
		public String healthCheck() {
			logger.info("Inside HealthCheck function");
			return "Audit Checklist Microservice is Active";
		}
		
		
		
	// Endpoint for retrieving the questions from the database
		
		@PostMapping("/AuditCheckListQuestions")
		public List<Question> getAuditCheckListQuestions(@RequestBody AuditType auditType) {
			
			logger.info("Inside getAuditCheckListQuestions function");
			
			List<Question> questions = new ArrayList<Question>();
			
			questions = questionService.getQuestionsByAuditType(auditType);
			
			return questions;
		}
	
}
