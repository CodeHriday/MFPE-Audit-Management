package com.cognizant.auditchecklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditchecklist.model.Question;
import com.cognizant.auditchecklist.service.AuthorizationService;
import com.cognizant.auditchecklist.service.QuestionService;
import com.cognizant.auditchecklist.model.AuditType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
//@RequestMapping("/checklist")
@CrossOrigin(origins = "*")
public class AuditCheckListController {
	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	
	Logger logger = LoggerFactory.getLogger("Audit-Checklist-Controller-Logger");
	
	
	// Endpoint to check if the checklist microservice is active 
	
		@GetMapping("/health-check")
		public String healthCheck() {
			logger.info("Inside HealthCheck function");
			return "Audit Checklist Microservice is Active";
		}
		
		
		
	// Endpoint for retrieving the questions from the database
		
		@PostMapping("/AuditCheckListQuestions")
		public List<?> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType) {
			
			logger.info("Inside HealthCheck function");
			
			List<Question> questions = new ArrayList<Question>();
			List<String> error = new ArrayList<String>();
			error.add("Some Error has Occurred");
			
			logger.info("JWT (from authorization header) :: " + jwt);
			
			// checking if the token is valid or not
			if(jwt.length()>0 && authorizationService.validateJwt(jwt)) 
			{	
				questions = questionService.getQuestionsByAuditType(auditType);
				return questions;
			}
			else{
				logger.error("JWT Token is not valid!!!");
				error.add("JWT Token is not valid!!!");
			}
			
			return error;
		}
		
}
