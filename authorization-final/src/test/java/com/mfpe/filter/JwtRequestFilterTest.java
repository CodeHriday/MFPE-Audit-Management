package com.mfpe.filter;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

@SpringBootTest
class JwtRequestFilterTest {

	@Mock
	private ProjectManagerDetailsService projectManagerDetailsService;

	@Mock
	private JwtService jwtService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Test
	public void testDoFilterInternal() {
		//httpServletRequest request;

	}

}
