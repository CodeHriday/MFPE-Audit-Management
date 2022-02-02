package com.mfpe.pod2cohort23.AuditAuthorization.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUserDetails;
import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUser;

@Service
public class projectUserDetailsUtil {
	@Autowired
	private projectUserUtil projectUserUtil;
	
	// this method returns the User object based on the user name...
	// whose password will get checked with the password we provided in this User object..
	// if match --> authenticated , if not match --> user not authenticated
	/*
	 * the method returns the user object based on the user name. and the password is checked. if the password is a match it will be authenticated
	 */
	@Override
	public projectUserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	/*
	 * it gets the projectUser from projectUserUtil and from there it gets the projectUserDetails from projectUser.
	 * i.e    projectUser<-projectUserUtil<-projectUser
	 * this is then used in the securityConfiguration class
	 */
	{
		projectUserDetails projectUserDetails = null;
		projectUser projectUser = projectUserUtil.getProjectUserByUserName(username);
		
		if(projectUserDetails!=null) 
		{
			projectUserDetails = new projectUserDetails(projectUserUtil.getProjectUserByUserName(username));
		}
		
		return projectUserDetails;
	}
}
