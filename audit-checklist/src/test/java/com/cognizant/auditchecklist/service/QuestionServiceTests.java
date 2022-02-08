package com.cognizant.auditchecklist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.auditchecklist.model.AuditType;
import com.cognizant.auditchecklist.model.Question;
import com.cognizant.auditchecklist.repository.QuestionRepo;

/*
 * Class to test QuestionService
 */

@SpringBootTest
public class QuestionServiceTests {
	
	@Mock
	QuestionRepo questionRepo;
	
	@InjectMocks
	QuestionServiceImpl questionService;
	
	@Test
	void contextLoads() {
		assertNotNull(questionService);
	}
	
	@Test
	void testGetQuestionsByAuditType() {
		
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(11,"question","auditType","response"));
		AuditType auditType = new AuditType("auditType");
		
		when(questionRepo.getQuestionsByAuditType("auditType")).thenReturn(questions);
		assertEquals(questions, questionService.getQuestionsByAuditType(auditType));
		
	}
	
}
