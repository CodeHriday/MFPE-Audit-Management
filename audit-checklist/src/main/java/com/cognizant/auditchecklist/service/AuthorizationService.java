package com.cognizant.auditchecklist.service;

/*
 * service interface for declaring authorization functions
 */

public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
