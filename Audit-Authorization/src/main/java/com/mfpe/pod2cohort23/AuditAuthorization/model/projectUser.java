package com.mfpe.pod2cohort23.AuditAuthorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user_login")
@NoArgsConstructor
@AllArgsConstructor
/*
 * this class contains the id, username, password and projectname variables for the projectUser. 
 * we are using lombok for boiler plate codes such as getter and setters etc
 */
public class projectUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private String projectName;
	
}