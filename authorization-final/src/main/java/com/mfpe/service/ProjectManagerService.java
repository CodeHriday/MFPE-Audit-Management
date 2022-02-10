package com.mfpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.repository.ProjectManagerRepo;
import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.model.ProjectManager;

@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;
	/*
	 * calling the projectManagerRepo to see if the user details exist or not.
	 * we are throwing ProjectManagerNotFoundException if the details are not found
	 */
	public ProjectManager getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException{
		ProjectManager projectManager = null;
		projectManager = projectManagerRepo.getProjectManagerByUserName(username);
		if(projectManager==null) {
			throw new ProjectManagerNotFoundException("Given User Details do not exist");
		}
		return projectManager;
	}
}
