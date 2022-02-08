Audit-Severity-Microservice :

This module is used for checking the severity of the audit by invoking the Benchmark and Checklist Microservice as Request from the portal. This microservice will return the status of the audit response by giving the project execution status and the remedial action.


--Endpoints :

Method	  Endpoint Path	              Returns
POST	  /ProjectExecutionStatus	  Audit Severity



--Dependencies on Other microsevices :

 Audit-Authorization,Audit-Checklist,Audit-Benchmark
 
 
--Application Properties Toggle :

spring.application.name=AuditSeverity
server.port=8300
server.servlet.context-path=/severity
User Database : H2(In-Memory)