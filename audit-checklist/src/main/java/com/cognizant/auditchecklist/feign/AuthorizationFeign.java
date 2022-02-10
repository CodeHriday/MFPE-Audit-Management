package com.cognizant.auditchecklist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.auditchecklist.model.AuthenticationResponse;

//setting up feign client to interact with authorization microservice
@FeignClient(name="Authorization-Ms", url = "${ms.auth}")
public interface AuthorizationFeign{
	
	//endpoint defined authorization microservice that validates the token
	@PostMapping("/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}
