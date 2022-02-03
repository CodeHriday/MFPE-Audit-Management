package com.cognizant.auditchecklist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * POJO class for Audit Type (Internal or sox)
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditType {

	String auditType;
}
