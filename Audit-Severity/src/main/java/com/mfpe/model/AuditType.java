package com.mfpe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * POJO class for Audit Type (Internal or sox)
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditType {

	//Variable auditType is used to store the Type of Audit

	String auditType;
}