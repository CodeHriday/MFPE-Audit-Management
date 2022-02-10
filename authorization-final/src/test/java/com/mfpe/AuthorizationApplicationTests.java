package com.mfpe;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuditAuthorizationApplicationTests {
	
	@Mock
	AuditAuthorizationApplication applicationMain;
	
	@Test
	void contextLoads() {
		assertNotNull(applicationMain);
		//assertEquals("Audit Authorization has started");
	}
	
	@Test
    public void testMain(){
        AuditAuthorizationApplication.main(new String[] {});
    }

}
