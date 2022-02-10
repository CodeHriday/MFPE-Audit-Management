package com.cognizant.auditchecklist;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
/*
 * Class to test AuditCheckListApplication Spring boot application
 */

@SpringBootTest
class AuditChecklistApplicationTests {

	@Mock
	AuditChecklistApplication auditChecklistApplication;
	
	@Test
	void contextLoads() {
		assertNotNull(auditChecklistApplication);
	}
	
	//Testing main method
//	@Test
//    public void testMain() throws IOException{
//        AuditChecklistApplication.main(new String[] {});
//    }
	
	

}
