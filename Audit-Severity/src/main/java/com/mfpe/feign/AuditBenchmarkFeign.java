package com.mfpe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuditBenchmark;

@FeignClient(url = "${ms.benchmark}",name="audit-benchmark")
public interface AuditBenchmarkFeign {
	
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<List<AuditBenchmark>> getAuditBenchmark(@RequestHeader("Authorization") String jwt); 
	
}