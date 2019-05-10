package com.group5.projectplanner.app;

import java.util.List;
import java.util.ArrayList;
//Author: Casper (s163950)
public class NullProject extends AbstractProject{
	
	private String projNotExist = "Project does not exist";
	
	@Override
	public void setID(ProjectID projectID) {}
	
	@Override
	public ProjectID getID() {
		return null;
	}
	
	@Override
	public void setName(String name, DeveloperID developerID){}
	
	@Override
	public String getName() { 
		return "Not available";
	}
	
	@Override
	public void setStartYear(String start) throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setStartWeek(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setEndYear(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setEndWeek(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	
	@Override
	public int getStartYear() throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public ProjectData getProjectInformation(DeveloperID developerID) throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getStartWeek() throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getEndYear() throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getEndWeek() throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public boolean isNil(){
		return true;
	}
	
	@Override
	public void setProjectLeader(DeveloperID developerID) throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public boolean isProjectLeader(DeveloperID developerID){
		return false;
	}
	
	@Override
	public void addProjectActivity(Activity projectActivity, DeveloperID developerID)
			throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public boolean checkActivityExists(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
		
	}

	@Override
	public void assignDeveloper(ActivityID activityID, DeveloperID developerID, Developer assignedDeveloper)
			throws OperationNotAllowedException, NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public boolean checkDeveloperAssigned(ActivityID activityID, DeveloperID assignedDeveloperID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public void setExpectedHours(ActivityID activityID, DeveloperID developerID, String hours)
			throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public double getExpectedHours(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public void setActivityComplete(ActivityID activityID, DeveloperID developerID)
			throws NullObjectException{
		throw new NullObjectException(projNotExist);
	}

	@Override
	public void setActivityStartWeek(String week ,ActivityID activityID, DeveloperID devLeader) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setActivityStartYear(String week ,ActivityID activityID, DeveloperID devLeader) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setActivityEndWeek(String week ,ActivityID activityID, DeveloperID devLeader) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public void setActivityEndYear(String week ,ActivityID activityID, DeveloperID devLeader) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public boolean isActivityComplete(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public List<Activity> getIncompleteActivities(DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public AbstractActivity getProjectActivity(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getActivityStartWeek(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getActivityStartYear(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	
	@Override
	public int getActivityEndWeek(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public int getActivityEndYear(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}
	
	@Override
	public DeveloperID getProjectLeader() throws NullObjectException {
		throw new NullObjectException(projNotExist);
	}

	@Override
	public void setActivityName(ActivityID activityID, String name, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException(projNotExist);
		
	}
	

	
}
