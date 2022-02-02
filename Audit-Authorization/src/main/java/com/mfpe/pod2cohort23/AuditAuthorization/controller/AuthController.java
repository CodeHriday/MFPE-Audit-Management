package com.mfpe.pod2cohort23.AuditAuthorization.controller;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.pod2cohort23.AuditAuthorization.model.AuthRequest;
import com.mfpe.pod2cohort23.AuditAuthorization.model.AuthResponse;
import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUserDetails;
import com.mfpe.pod2cohort23.AuditAuthorization.util.projectUserDetailsUtil;
import com.mfpe.pod2cohort23.AuditAuthorization.util.JwtUtil;

@RestController
@RequestMapping("/auth")	//Context Root
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private projectUserDetailsUtil projectManagerDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	Logger logger = LoggerFactory.getLogger("Auth-Controller-Logger");
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck(){	// for Health check [PERMITTED FOR ALL]
		return new ResponseEntity<String>("Audit-Authorization MS Running Fine!!", HttpStatus.OK);
	}
	
	// authentication - for the very first login
	@PostMapping("/authenticate")
	public ResponseEntity<String> generateJwt(@Valid @RequestBody AuthRequest request){
		ResponseEntity<String> response = null;
		
		// authenticating the User-Credentials
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			// else when it authenticates successfully
			final projectUserDetails projectUserDetails = projectUserDetailsUtil.loadUserByUsername(request.getUsername());
			
			final String jwt = jwtUtil.generateToken(projectUserDetails);	// returning the token as response
			
			//test
			logger.info("Authenticated User :: " + projectUserDetails);
			
			response = new ResponseEntity<String>(jwt, HttpStatus.OK);
			
			logger.info("Successfully Authenticated user!");
			
		}catch (Exception e) {
			logger.error(e.getMessage() + "!! info about request-body : " + request);
			response = new ResponseEntity<String>("Not Authorized Project Manager", HttpStatus.FORBIDDEN);
		}
		logger.info("-------- Exiting /authenticate");
		return response;
	}
	
	// validate - for every request it validates the user-credentials from the provided Jwt token in Authorization req. header
	@PostMapping("/validate")
	public ResponseEntity<AuthResponse> validateJwt(@RequestHeader("Authorization") String jwt){
		
		AuthResponse authenticationResponse = new AuthResponse("Invalid", "Invalid", false);
		ResponseEntity<AuthResponse> response = null;

		//first remove Bearer from Header
		jwt = jwt.substring(7);
		
		//check token
		logger.info("--------JWT :: "+jwt);
		
		
		// check the jwt is proper or not
		final projectUserDetails projectUserDetails = projectManagerDetailsService.loadUserByUsername(jwtUtil.extractUsername(jwt));
		
		// now validating the jwt
		try {
			if(jwtUtil.validateToken(jwt, projectUserDetails)) {
				authenticationResponse.setName(projectUserDetails.getName());
				authenticationResponse.setProjectName(projectUserDetails.getProjectName());
				authenticationResponse.setValid(true);
				response = new ResponseEntity<AuthResponse>(authenticationResponse, HttpStatus.OK);
				logger.info("Successfully validated the jwt and sending response back!");
			}
			else {
				response = new ResponseEntity<AuthResponse>(authenticationResponse, HttpStatus.OK);
				logger.error("JWT Token validation failed!");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			response = new ResponseEntity<AuthResponse>(authenticationResponse, HttpStatus.OK);
			logger.error("Exception occured whil validating JWT : Exception info : " + e.getMessage());
		}
		logger.info("-------- Exiting /validate");
		return response;
	}
	
}