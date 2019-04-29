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

	
	public void assignDeveloper(ProjectActivity projectActivity, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException {
		Activity abstActivity = getActivityRef(projectActivity);
		abstActivity.assignDeveloper(assignedDeveloper);
	}
	
	
	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Developer assignedDeveloper) throws NullObjectException {
		Activity abstActivity = getActivityRef(projectActivity);
		return abstActivity.checkDeveloperAssigned(assignedDeveloper);
	}
	
	public void setExpectedHours(ProjectActivity projectActivity, String hours) throws NullObjectException, FormattingException {
		Activity abstActivity = getActivityRef(projectActivity);
		abstActivity.setExpectedWorkHours(hours);
	}
	
	public double getExpectedHours(ProjectActivity projectActivity) throws NullObjectException {
		Activity abstActivity = getActivityRef(projectActivity);
		return abstActivity.getExpectedWorkHours();
	}
	
	
	public void setActivityComplete(ProjectActivity projectActivity) throws NullObjectException {
		Activity abstActivity = getActivityRef(projectActivity);
		abstActivity.setActivityComplete();
	}
	
	public boolean isActivityComplete(ProjectActivity projectActivity) throws NullObjectException {
		Activity abstActivity = getActivityRef(projectActivity);
		return abstActivity.isActivityComplete();
	}
	
	//Internal helper functions
	private Activity getActivityRef(ProjectActivity projectActivity){
		for(ProjectActivity projAct : projectActivities){
			if(projAct.equals(projectActivity)){
				return projAct;
			}
		}
		return new NullActivity();
	}

	

	

	

	

	
	
	
}
