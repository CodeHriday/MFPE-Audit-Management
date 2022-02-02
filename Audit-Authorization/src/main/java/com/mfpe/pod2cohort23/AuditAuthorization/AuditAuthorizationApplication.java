package com.mfpe.pod2cohort23.AuditAuthorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuditAuthorizationApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(AuditAuthorizationApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AuditAuthorizationApplication.class, args);
		LOGGER.info("Start");
	}

}
