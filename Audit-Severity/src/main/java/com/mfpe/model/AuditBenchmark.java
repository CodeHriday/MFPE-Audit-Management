package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditBenchmark {
	
	private int benchmarkId;
	
	//Variable auditType is used to store the Audit Type
	private String auditType;

	//Variable benchmarkNoAnswers is used to store the No Answers	
	private int benchmarkNoAnswers;
	
}