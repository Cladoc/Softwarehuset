package com.group5.projectplanner.app;
import java.util.*;

public class Project extends AbstractProject {
	private List<Activity> activities = new ArrayList<Activity> ();
	private int projectID;
	private String projectName;
	private Developer leader;
	private int startYear;

	@Override
	public void setID(int id) {
		this.projectID = id;
	}
	
	@Override
	public int getID() {
		return this.projectID;
	}
	
	@Override
	public void setName(String name) {
		this.projectName = name;
	}
	
	@Override
	public String getName() {
		return this.projectName;
	}
	
	//Author: Casper (s163950)
	@Override
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
	
	@Override
	public int getStartYear() {
		return this.startYear;
	}

	public void setProjectLeader(Developer developer) {
		leader = developer;
	}

	public boolean isProjectLeader(Developer developer) {
		return leader.equals(developer);
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Project){
			Project proj = (Project) obj;
			return this.projectName.equalsIgnoreCase(proj.getName());
		}else{
			return false;
		}
	}
	
	
	@Override
	public boolean isNil(){
		return false;
	}
}
