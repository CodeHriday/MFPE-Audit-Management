package com.mfpe.pod2cohort23.AuditAuthorization.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component
public class projectUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String username;
	private String password;
	private String projectName;
	
	public projectUserDetails() {
		
	}
	
	public projectUserDetails(projectUser projectUser) {
		this.id = projectUser.getId();
		this.name = projectUser.getName();
		this.username = projectUser.getUsername();
		this.password = new BCryptPasswordEncoder(10).encode(projectUser.getPassword());    //encoding the password using the security package from springframework
		this.projectName = projectUser.getProjectName();
	}
	
	public String getName() {
		return this.name;
	}

	public String getProjectName() {
		return this.projectName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

