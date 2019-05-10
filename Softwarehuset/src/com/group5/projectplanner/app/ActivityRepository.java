package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;
//Author: Marko (s163964)
public class ActivityRepository {
	
	private List<ProjectActivity> projectActivities = new ArrayList<ProjectActivity>();
	
	public void addActivity(ProjectActivity activity, Project parentProject) throws OperationNotAllowedException {
		if(!checkActivityExists(activity.getID())){
			activity.setParentProject(parentProject);
			projectActivities.add(activity);
		}else{
			throw new OperationNotAllowedException("Activity already exists");
		}
	}
	
	public boolean checkActivityExists(ActivityID activityID) {	
		for(ProjectActivity listActivity : projectActivities){
			if(listActivity.matches(activityID)){
				return true;
			}
		}
		return false;
	}
	
	public Activity getActivity(ActivityID activityID){
		for(ProjectActivity listActivity : projectActivities){
			if(listActivity.matches(activityID)){
				return listActivity;
			}
		}
		return new NullActivity();
	}
	
	public List<ProjectActivity> getIncompleteActivities() {
		List<ProjectActivity> incompleteActivities = new ArrayList<ProjectActivity>();
		for(ProjectActivity listActivity : projectActivities){
			if(!listActivity.isActivityComplete()){
				incompleteActivities.add(listActivity);
			}
		}
		return incompleteActivities;
	}

	public List<ActivityID> getActivityIDs() {
		List<ActivityID> activityIDs = new ArrayList<>(); 
		for(ProjectActivity listActivity : projectActivities){
			activityIDs.add(listActivity.getID());
		}
		return activityIDs;
	}
}
