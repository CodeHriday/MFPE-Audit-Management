package com.mfpe.pod2cohort23.AuditAuthorization.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
/*
 * this class contains the name, isValid and projectname variables for the authentication response. 
 * we are using Lombok for boiler plate codes such as getter and setters etc
 */
public class AuthResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}