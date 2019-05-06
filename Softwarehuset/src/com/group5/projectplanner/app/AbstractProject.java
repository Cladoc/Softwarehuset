package com.group5.projectplanner.app;

//Author: Casper (s163950)
public abstract class AbstractProject {
	
	public abstract void setID(ProjectID projectID);
	public abstract ProjectID getID();
	public abstract void setName(String name, Developer devLeader) throws OperationNotAllowedException,FormattingException;
	public abstract String getName();
	public abstract void setStartYear(String start)  throws Exception, FormattingException, NullObjectException;
	public abstract void setEndYear(String start, Developer devLeader)  throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract int getStartYear() throws NullObjectException;
	public abstract int getStartWeek() throws NullObjectException;
	public abstract int getEndYear() throws NullObjectException;
	public abstract int getEndWeek() throws NullObjectException;
	public abstract void setStartWeek(String start, Developer devLeader) throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract void setEndWeek(String start, Developer devLeader) throws Exception, FormattingException, NullObjectException, OperationNotAllowedException;
	public abstract boolean equals(Object obj);
	public abstract boolean isNil();
	public abstract void setProjectLeader(Developer developer) throws NullObjectException;
	public abstract boolean isProjectLeader(Developer developer);
	public abstract void addProjectActivity(ProjectActivity projectActivity, Developer devLeader) throws OperationNotAllowedException, NullObjectException;
	public abstract boolean checkActivityExists(ActivityID activityID) throws NullObjectException;
	public abstract void assignDeveloper(ActivityID activityID, Developer devLeader, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException;
	public abstract boolean checkDeveloperAssigned(ActivityID activityID, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException;
	public abstract void setExpectedHours(ActivityID activityID, Developer devLeader, String hours) throws OperationNotAllowedException, NullObjectException, FormattingException;
	public abstract double getExpectedHours(ActivityID activityID) throws NullObjectException;
	public abstract void setActivityComplete(ActivityID activityID, Developer devLeader) throws NullObjectException, OperationNotAllowedException;
	public abstract boolean isActivityComplete(ActivityID activityID) throws NullObjectException;
	public abstract String getProjectInformation(Developer devLeader) throws OperationNotAllowedException, NullObjectException;
}
