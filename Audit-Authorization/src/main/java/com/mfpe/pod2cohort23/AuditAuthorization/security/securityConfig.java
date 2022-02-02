package com.mfpe.pod2cohort23.AuditAuthorization.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mfpe.pod2cohort23.AuditAuthorization.jwtFilter.jwtRequestFilter;
import com.mfpe.pod2cohort23.AuditAuthorization.util.projectUserDetailsUtil;


@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private projectUserDetailsUtil projectUserDetailsUtil;
	
	@Autowired
	private jwtRequestFilter jwtRequestFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);		// strength of BCrypthPasswordEncoder = 10
	}
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(projectUserDetailsUtil).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/auth/health-check", "/auth/authenticate", "/auth/validate").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	// stopping default session creation
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);	// adding the filter
	}
}
