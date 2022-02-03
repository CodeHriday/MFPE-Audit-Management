package com.cognizant.auditchecklist.feign;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name="audit-authorization", url = "${audit-auth-url}")
public interface AuthorizationFeign{


}
