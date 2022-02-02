package com.mfpe.pod2cohort23.AuditAuthorization.jwtFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mfpe.pod2cohort23.AuditAuthorization.exception.ProjectUserNotFoundException;
import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUserDetails;
import com.mfpe.pod2cohort23.AuditAuthorization.util.JwtUtil;
import com.mfpe.pod2cohort23.AuditAuthorization.util.projectUserDetailsUtil;

@Component
public class jwtRequestFilter extends OncePerRequestFilter
/*
 * any incoming request this Filter class gets executed.
 * It checks if the request has a valid JWT token. 
 * If it has a valid JWT Token then it sets the Authentication in the context, to specify that the current user is authenticated.
 */
{
	@Autowired
	private projectUserDetailsUtil projectUserDetailsUtil;

	@Autowired
	private JwtUtil JwtUtil;
	
	Logger logger = LoggerFactory.getLogger("Jwt-Request-Filter");

	// an added security layer to authorize all the requests if they have valid jwt or not
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException 
	{	
		final String jwtRequestHeader = request.getHeader("Authorization");
		
		logger.info("Inside JwtRequestFilter : " + request.getRequestURI());
		
		String jwt = null, username = null;
		if (jwtRequestHeader != null && jwtRequestHeader.startsWith("Bearer ")) 
		{
			jwt = jwtRequestHeader.substring(7);
			try
			{
				username = JwtUtil.extractUsername(jwt);
				logger.info("Successfully obtained username : (" + username + ") from JWT");
			} 
			catch (Exception e) 
			{
				logger.error(e.getMessage());
			}
		} 
		else
		{
			logger.error("Problem with JWT token obtained from Request-Header. JWT :: "+jwt);
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) 
		{
			projectUserDetails projectUserDetails = projectUserDetailsUtil.loadUserByUsername(username);
			if (JwtUtil.validateToken(jwt, projectUserDetails)) 
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(projectUserDetails, null,projectUserDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				logger.info("Successfully obtained and validated JWT :: "+jwt);
			}
			else 
			{
				logger.error("Validation failed for JWT :: "+jwt);
			}
		}
		else 
		{
			logger.error("Problem with JWT token obtained from Request-Header. JWT :: "+jwt);
		}
		logger.info("-------- Exiting JwtRequestFilter");
		filterChain.doFilter(request, response);
	}
}
