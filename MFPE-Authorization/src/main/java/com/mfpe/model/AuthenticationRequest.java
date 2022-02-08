package com.mfpe.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * this is the fields/values that are in the authentication request
 * username
 * password
 * we are using lombok for the boiler plate codes
 */
@Component
@Getter
@Setter
@ToString
public class AuthenticationRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
