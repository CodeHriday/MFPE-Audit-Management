package com.cognizant.auditchecklist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients    //enables interaction between microservices
public class AuditChecklistApplication {

	
	static Logger logger = LoggerFactory.getLogger("Audit-Checklist-Application-Logger");
	
	public static void main(String[] args) {
		SpringApplication.run(AuditChecklistApplication.class, args);
		logger.info("\nAudit CheckList Microservice Started");
	}

}
