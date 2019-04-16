package com.group5.projectplanner.app;
import java.util.*;

public class Project {
	private int projectID;
	private String projectName;
	private Developer leader;
	private int startYear;
	private List<Activity> activities = new ArrayList<Activity> ();
	
	public void setID(int id) {
		this.projectID = id;
	}
	
	public int getID() {
		return this.projectID;
	}
	
	public void setName(String name) {
		this.projectName = name;
	}
	
	public String getName() {
		return this.projectName;
	}
	
	//Author: Casper (s163950)
	public void setStartYear(String start) throws Exception, FormattingException {
		try{
			int number = Integer.parseInt(start);
			if(number < 1000 || number > 9999)
			{
				throw new FormattingException("Incorrect date format");
			}
			this.startYear = number;
		}catch (Exception e){
			throw new FormattingException("Incorrect date format");
		}
	}
	
	public int getStartYear() {
		return this.startYear;
	}

	public void setProjectLeader(Developer developer) {
		leader = developer;
	}

	public boolean isProjectLeader(Developer developer) {
		return leader.equals(developer);
	}
}
