package com.mfpe.pod2cohort23.AuditAuthorization.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
/*
 * this class contains the username and password variables for the authentication request. 
 * we are using Lombok for boiler plate codes such as getter and setters etc
 */
public class AuthRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}