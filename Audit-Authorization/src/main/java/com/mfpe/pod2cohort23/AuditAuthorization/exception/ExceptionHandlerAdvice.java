package com.mfpe.pod2cohort23.AuditAuthorization.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mfpe.pod2cohort23.AuditAuthorization.model.AuthResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger("Exception Handler Advice");
	
	// this method handles any exception that occurs during validation
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> validationExceptions(MethodArgumentNotValidException ex) {
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        logger.error(error.getDefaultMessage());
	    });
	    return new ResponseEntity<String>("Enter the Credentials properly", HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
		logger.error(e.getMessage());
		AuthResponse authenticationResponse = new AuthResponse("Invalid", "Invalid", false);	// we are sending an Invalid response if an exception occurs
		return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
	}
}