package com.cognizant.auditchecklist.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * POJO class that stores the response returned 
 * after token validation.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
	private String name;  
	private String projectName;
	private boolean isValid;
}
