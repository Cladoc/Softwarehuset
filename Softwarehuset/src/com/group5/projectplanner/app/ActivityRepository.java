package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepository {
	
	private List<ProjectActivity> projectActivities = new ArrayList<ProjectActivity>();
	
	public void addActivity(ProjectActivity projectActivity, Project parentProject) throws OperationNotAllowedException {
		if(!checkActivityExists(projectActivity)){
			projectActivity.setParentProject(parentProject);
			projectActivities.add(projectActivity);
		}else{
			throw new OperationNotAllowedException("Activity already exists");
		}
	}
	
	public boolean checkActivityExists(ProjectActivity projectActivity) {
		//contains(obj o) uses object's equals() method
		return projectActivities.contains(projectActivity);
	}
	
	public Activity getActivity(ProjectActivity projectActivity){
		for(ProjectActivity projAct : projectActivities){
			if(projAct.equals(projectActivity)){
				return projAct;
			}
		}
		return new NullActivity();
	}
}
