package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mfpe.model.AuditResponse;

@SpringBootTest
public class ExceptionTests {

	@Autowired
	ExceptionHandlerAdvice exceptionHandlerAdvice;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(exceptionHandlerAdvice);
	}
	
	@Test
	public void testException() {
		AuditResponse auditResponse = new AuditResponse();
		Exception e = new Exception();
		assertEquals(new ResponseEntity<>(auditResponse, HttpStatus.OK),exceptionHandlerAdvice.exception(e));
	}
}