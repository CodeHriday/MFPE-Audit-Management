package com.cognizant.auditchecklist.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * POJO class that stores the response returned 
 * after token validation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
	private String name;  
	private String projectName;
	private boolean isValid;
}
