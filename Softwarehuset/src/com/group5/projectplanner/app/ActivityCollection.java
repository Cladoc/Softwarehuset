package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;
public class ActivityCollection {

	private List<Activity> projectActivities = new ArrayList<Activity>();

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
	
	
}
