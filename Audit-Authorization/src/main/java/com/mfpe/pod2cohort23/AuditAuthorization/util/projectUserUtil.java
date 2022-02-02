package com.mfpe.pod2cohort23.AuditAuthorization.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.pod2cohort23.AuditAuthorization.repository.projectUserRepo;
import com.mfpe.pod2cohort23.AuditAuthorization.exception.ProjectUserNotFoundException;
import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUser;


public class projectUserUtil {
	@Autowired
	private projectUserRepo projectUserRepo;
	
	public projectUser getProjectUserByUserName(String username) throws ProjectUserNotFoundException
	/*
	 * this method is checking if the user details exist or not
	 */
	{
		projectUser projectUser = null;
		projectUser = projectUserRepo.getProjectUserByUserName(username);
		if(projectUser==null) {
			throw new ProjectUserNotFoundException("Given User-Details does not exist.");
		}
		return projectUser;
	}
}
