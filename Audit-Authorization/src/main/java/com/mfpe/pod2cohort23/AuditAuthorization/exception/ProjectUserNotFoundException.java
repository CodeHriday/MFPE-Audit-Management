package com.mfpe.pod2cohort23.AuditAuthorization.exception;

public class ProjectUserNotFoundException extends Exception { 	//extends RuntimeException
private static final long serialVersionUID = 1L;
	
	public ProjectUserNotFoundException(String message) {
		super(message);
	}
}
