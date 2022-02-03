package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {
	
	//Variable projectName is used to store the Name of the Project
	private String projectName;
	
	//Variable managerName is used to store the Manager Name of the Project
	private String managerName;
	
	//Variable auditDetails is used to store the AuditDetails of the Project
	private AuditDetail auditDetail;
	
}