package com.cognizant.auditchecklist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditchecklist.feign.AuthorizationFeign;
import com.cognizant.auditchecklist.model.AuthenticationResponse;

/*
 * service class that implements functions of authorization service interface
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	private AuthorizationFeign authClient;
	
	//this functions calls the validate function of auth feign client
	@Override
	public boolean validateJwt(String jwt) {
		AuthenticationResponse authenticationResponse = authClient.validate(jwt).getBody();
		return authenticationResponse.isValid();
	}
	
	
}
