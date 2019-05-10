package com.group5.projectplanner.app;

import java.util.List;

//Author: Casper (s163950)
public abstract class AbstractProject {
	
	public abstract void setID(ProjectID projectID);
	public abstract ProjectID getID();
	public abstract DeveloperID getProjectLeader() throws NullObjectException;
	public abstract void setName(String name, DeveloperID developerID) throws OperationNotAllowedException,FormattingException;
	public abstract String getName();
	public abstract void setStartYear(String start)  throws Exception, FormattingException, NullObjectException;
	public abstract void setEndYear(String start, DeveloperID developerID)  throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract int getStartYear() throws NullObjectException;
	public abstract int getStartWeek() throws NullObjectException;
	public abstract int getEndYear() throws NullObjectException;
	public abstract int getEndWeek() throws NullObjectException;
	public abstract void setStartWeek(String start, DeveloperID developerID) throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract void setEndWeek(String start, DeveloperID developerID) throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract boolean equals(Object obj);
	public abstract boolean isNil();
	public abstract void setProjectLeader(DeveloperID developerID) throws NullObjectException;
	public abstract boolean isProjectLeader(DeveloperID developerID);
	public abstract void addProjectActivity(Activity projectActivity, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException;
	public abstract boolean checkActivityExists(ActivityID activityID) throws NullObjectException;
	public abstract void assignDeveloper(ActivityID activityID, DeveloperID developerID, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException;
	public abstract boolean checkDeveloperAssigned(ActivityID activityID, DeveloperID assignedDeveloperID) throws OperationNotAllowedException, NullObjectException;
	public abstract void setExpectedHours(ActivityID activityID, DeveloperID developerID, String hours) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract double getExpectedHours(ActivityID activityID) throws NullObjectException;
	public abstract void setActivityComplete(ActivityID activityID, DeveloperID developerID) throws NullObjectException, OperationNotAllowedException;
	public abstract boolean isActivityComplete(ActivityID activityID) throws NullObjectException;
	public abstract ProjectData getProjectInformation(DeveloperID developerID) throws OperationNotAllowedException, NullObjectException;
	public abstract AbstractActivity getProjectActivity(ActivityID activityID) throws NullObjectException;
	public abstract List<Activity> getIncompleteActivities(DeveloperID developerID) throws NullObjectException, OperationNotAllowedException;
	public abstract void setActivityStartWeek(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract void setActivityStartYear(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract void setActivityEndWeek(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract void setActivityEndYear(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract int getActivityStartWeek(ActivityID activityID) throws NullObjectException;
	public abstract int getActivityStartYear(ActivityID activityID) throws NullObjectException;
	public abstract int getActivityEndWeek(ActivityID activityID) throws NullObjectException;
	public abstract int getActivityEndYear(ActivityID activityID) throws NullObjectException;
	public abstract void setActivityName(ActivityID activityID, String string, DeveloperID developerID) throws NullObjectException, FormattingException, OperationNotAllowedException;
	
	
	
}
