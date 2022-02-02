package com.mfpe.pod2cohort23.AuditAuthorization.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	private String secret;				// secret variable to store the secret key for JWT
	private int jwtExpirationInMs;		// variable to store the expiration value for JWT
	
	@Value("${jwt.secret}")
	public void setSecret(String secret) 		// this refers to the secret value in the application.properties file
	{
		this.secret=secret;
	}
	
	@Value("${jwt.expirationInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) 		// this refers to the expiration value in the application.properties file
	{
		this.jwtExpirationInMs = jwtExpirationInMs;
	}
	public String extractUsername(String token) 			// the function is for extracting the username from the token
	{			
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) 			// the function is for extracting the expiration value from the token 			
    {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) 			// the function is for extracting a particular claim or the sub part from the token 
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    private Claims extractAllClaims(String token) 			// the function is for extracting the claims or the sub parts from the token by using the secret value 
    {
    	String formated_token = token.trim().replaceAll("\0xfffd", "");
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(formated_token).getBody();
    }

    private Boolean isTokenExpired(String token) 			// the function is for verifying the tokens expiration 
    {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(projectUserDetails projectUserDetails) 			// the function is for generating the token using the projectUserDetails class. it is using the username value from the database 
    																		// the projectUserDetails.java page contains the id, name, username, password and project name 
    {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, projectUserDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String username) 			// the function is for using the HS256 Algo for signing the token
    {

        return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs*60*1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, projectUserDetails projectUserDetails) 			// the function is for validating the token
    																							// the token is being validated against the username and the expiration of the token
    {
        final String username = extractUsername(token);
        return (username.equals(projectUserDetails.getUsername()) && !isTokenExpired(token));
    }
}
