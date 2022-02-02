package com.mfpe.pod2cohort23.AuditAuthorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.pod2cohort23.AuditAuthorization.model.projectUser;

@Repository
public interface projectUserRepo extends JpaRepository<projectUser, Integer> {
	@Query(value = "SELECT p FROM user_login p WHERE p.username = ?1")
	public projectUser getProjectUserByUserName(String username);
}
