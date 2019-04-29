package com.group5.projectplanner.app;

//Author: Casper (s163950)
public abstract class AbstractProject {
	
	public abstract void setID(int id);
	public abstract int getID();
	public abstract void setName(String name);
	public abstract String getName();
	public abstract void setStartYear(String start)  throws Exception, FormattingException;
	public abstract void setEndYear(String start)  throws Exception, FormattingException;
	public abstract int getStartYear();
	public abstract int getStartWeek();
	public abstract int getEndYear();
	public abstract int getEndWeek();
	public abstract boolean equals(Object obj);
	public abstract boolean isNil();
	public abstract void setProjectLeader(Developer developer) throws NullObjectException;
	public abstract boolean isProjectLeader(Developer developer);
	public abstract void setStartWeek(String start) throws Exception, FormattingException;
	public abstract void setEndWeek(String start) throws Exception, FormattingException;
}
