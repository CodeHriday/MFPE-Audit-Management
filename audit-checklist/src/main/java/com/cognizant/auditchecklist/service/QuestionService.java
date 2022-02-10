package com.cognizant.auditchecklist.service;

import java.util.List;

import com.cognizant.auditchecklist.model.AuditType;
import com.cognizant.auditchecklist.model.Question;
/*
 * service interface for declaring functions for accessing data from repository
 */
public interface QuestionService {

	public List<Question> getQuestionsByAuditType(AuditType auditType);
}
