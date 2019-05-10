package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;
//Author: Marko (s163964)
public class ActivityRepository {
	
	private List<Activity> projectActivities = new ArrayList<Activity>();
	
	public void addActivity(Activity activity, Project parentProject) throws OperationNotAllowedException {
		if(!checkActivityExists(activity.getID())){
			activity.setParentProject(parentProject);
			projectActivities.add(activity);
		}else{
			throw new OperationNotAllowedException("Activity already exists");
		}
	}
	
	public boolean checkActivityExists(ActivityID activityID) {	
		for(Activity listActivity : projectActivities){
			if(listActivity.matches(activityID)){
				return true;
			}
		}
		return false;
	}
	
	public AbstractActivity getActivity(ActivityID activityID){
		for(Activity listActivity : projectActivities){
			if(listActivity.matches(activityID)){
				return listActivity;
			}
		}
		return new NullActivity();
	}
	
	public List<Activity> getIncompleteActivities() {
		List<Activity> incompleteActivities = new ArrayList<Activity>();
		for(Activity listActivity : projectActivities){
			if(!listActivity.isActivityComplete()){
				incompleteActivities.add(listActivity);
			}
		}
		return incompleteActivities;
	}
}
