package com.cognizant.auditchecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.auditchecklist.model.Question;

/*
 * repository for audit questions
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	// Retrieves the data i.e audit_questions from the database based on the given auditType
	
	@Query(value = "SELECT q FROM Question q WHERE q.auditType=?1")
	List<Question> getQuestionsByAuditType(String auditType);
	
}
