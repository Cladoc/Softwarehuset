package com.group5.projectplanner.app;

import java.util.List;

//Author: Casper (s163950)
public class NullProject extends AbstractProject{
	
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
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setStartWeek(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setEndYear(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setEndWeek(String start, DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	
	@Override
	public int getStartYear() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public prjData getProjectInformation(DeveloperID developerID) throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getStartWeek() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getEndYear() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getEndWeek() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
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
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public boolean isProjectLeader(DeveloperID developerID){
		return false;
	}
	
	@Override
	public void addProjectActivity(ProjectActivity projectActivity, DeveloperID developerID)
			throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean checkActivityExists(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
		
	}

	@Override
	public void assignDeveloper(ActivityID activityID, DeveloperID developerID, Developer assignedDeveloper)
			throws OperationNotAllowedException, NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean checkDeveloperAssigned(ActivityID activityID, DeveloperID assignedDeveloperID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setExpectedHours(ActivityID activityID, DeveloperID developerID, String hours)
			throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public double getExpectedHours(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setActivityComplete(ActivityID activityID, DeveloperID developerID)
			throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean isActivityComplete(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public List<ProjectActivity> getIncompleteActivities(DeveloperID developerID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public Activity getProjectActivity(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public DeveloperID getProjectLeader() throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
}
