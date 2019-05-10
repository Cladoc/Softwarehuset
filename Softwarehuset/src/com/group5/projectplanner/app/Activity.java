package com.group5.projectplanner.app;


public abstract class Activity {
	
	public abstract void setName(String name) throws FormattingException;
	public abstract String getName();
	public abstract boolean isNil();
	public abstract boolean equals(Object obj);
	public abstract void assignDeveloper(Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException;
	public abstract boolean checkDeveloperAssigned(DeveloperID assignedDeveloper) throws NullObjectException;
	public abstract void setExpectedWorkHours(String hours) throws NullObjectException, FormattingException;
	public abstract double getExpectedWorkHours() throws NullObjectException;
	public abstract void setActivityComplete() throws NullObjectException;
	public abstract boolean isActivityComplete() throws NullObjectException;
	public abstract void setActivityStartWeek(String week) throws NullObjectException, FormattingException;
	public abstract void setActivityStartYear(String year) throws NullObjectException, FormattingException;
	public abstract void setActivityEndWeek(String week) throws NullObjectException, FormattingException;
	public abstract void setActivityEndYear(String year) throws NullObjectException, FormattingException;
	public abstract int getActivityStartWeek() throws NullObjectException;
	public abstract int getActivityStartYear() throws NullObjectException;
	public abstract int getActivityEndWeek() throws NullObjectException;
	public abstract int getActivityEndYear() throws NullObjectException;
}
