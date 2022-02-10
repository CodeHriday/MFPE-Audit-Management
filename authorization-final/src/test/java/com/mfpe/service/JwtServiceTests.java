package com.mfpe.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.repository.ProjectManagerRepo;

@SpringBootTest
public class JwtServiceTests {
	
	
	@Mock
	ProjectManagerRepo projectManagerRepo;
	
	@InjectMocks
	JwtService jwtService;
	
	@Test
	public void generateTokenTest() {
		ProjectManagerDetails details = new ProjectManagerDetails(1,"admin", "admin", "pwd","p1");
		String generateToken = jwtService.generateToken(details);
		assertNotNull(generateToken);	
	}
	
	@Test
	public void validateTokenTest(){
		ProjectManagerDetails details = new ProjectManagerDetails(1,"admin", "admin", "pwd","p1");
		Boolean validateToken = jwtService.validateToken(jwtService.generateToken(details), details);
		assertEquals(true, validateToken);
	}
	
	@Test
	public void validateTokenWithNameFalseTest(){
		ProjectManagerDetails details = new ProjectManagerDetails(1,"admin", "admin", "pwd","p1");
		ProjectManagerDetails details2 = new ProjectManagerDetails(2,"admin1", "admin1", "pwd1","p2");
		String generateToken = jwtService.generateToken(details);
		Boolean validateToken = jwtService.validateToken(generateToken, details2);
		assertEquals(false, validateToken);
	}
	
	@Test
	public void validateTokenWithNameTest() {
		ProjectManagerDetails details = new ProjectManagerDetails(1,"admin", "admin", "pwd","p1");
		String generateToken = jwtService.generateToken(details);
		Boolean validateToken = jwtService.validateToken(generateToken,details);
		assertEquals(true, validateToken);

	}
	
}
