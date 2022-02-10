package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
	
	private String name;
	private String projectName;
	
	//Variable isValid is used to store whether the token is valid or not.
	private boolean isValid;

}