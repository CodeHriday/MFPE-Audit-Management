package com.cognizant.auditchecklist.service;

import java.util.List;

import com.cognizant.auditchecklist.model.AuditType;
import com.cognizant.auditchecklist.model.Question;

public interface QuestionService {

	public List<Question> getQuestionsByAuditType(AuditType auditType);
}
