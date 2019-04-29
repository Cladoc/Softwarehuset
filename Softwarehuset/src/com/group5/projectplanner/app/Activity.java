package com.group5.projectplanner.app;


public abstract class Activity {
	
	public abstract void setName(String name);
	public abstract String getName();
	public abstract boolean isNil();
	public abstract boolean equals(Object obj);
	public abstract void assignDeveloper(Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException;
	public abstract boolean checkDeveloperAssigned(Developer assignedDeveloper) throws NullObjectException;
	public abstract void setExpectedWorkHours(String hours) throws NullObjectException, FormattingException;
	public abstract double getExpectedWorkHours() throws NullObjectException;
	public abstract void setActivityComplete() throws NullObjectException;
	public abstract boolean isActivityComplete() throws NullObjectException;
}
