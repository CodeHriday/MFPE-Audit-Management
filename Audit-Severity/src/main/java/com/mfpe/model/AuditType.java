package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuditType {

	//Variable auditType is used to store the Type of Audit
	
	private String auditType;
}