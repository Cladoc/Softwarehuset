package com.group5.projectplanner.app;

public abstract class abstractDeveloper {

	public abstract void setName(String name);
	public abstract String getName();	
	public abstract void registerHours(String week, String year, String hours, Activity activity) throws FormattingException, NullObjectException;
	public abstract boolean matches(DeveloperID developerID) throws NullObjectException;
	public abstract boolean isNil();
	public abstract double getHours(int week, int year) throws NullObjectException;
}
