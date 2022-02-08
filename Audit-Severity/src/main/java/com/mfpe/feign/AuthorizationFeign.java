package com.mfpe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuthenticationResponse;

@FeignClient(url = "${ms.auth}",name = "audit-auth")
public interface AuthorizationFeign{

	@PostMapping(value = "/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}