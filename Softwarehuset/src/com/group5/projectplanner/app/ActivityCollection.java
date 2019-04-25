package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Author: Casper (s163950)
public class ActivityCollection {

	private List<ProjectActivity> projectActivities = new ArrayList<ProjectActivity>();

	public void addActivity(ProjectActivity projectActivity) throws OperationNotAllowedException {
		if(!checkActivityExists(projectActivity)){
			projectActivities.add(projectActivity);
		}else{
			throw new OperationNotAllowedException("Activity already exists");
		}
	}

	public boolean checkActivityExists(ProjectActivity projectActivity) {
		//contains(obj o) uses object's equals() method
		return projectActivities.contains(projectActivity);
	}

	/*
	public void assignDeveloper(ProjectActivity projectActivity, Developer assignedDeveloper) {
		//abstProjectActivitygetActivityRef(projectActivity)
	}
	*/
	
	//Internal helper functions
	/*
	private Activity getActivityRef(ProjectActivity projectActivity){
		for(ProjectActivity projAct : projectActivities){
			if(projAct.equals(projectActivity)){
				return projAct;
			}
		}
		return new Activity();
	}
	*/
	
}
