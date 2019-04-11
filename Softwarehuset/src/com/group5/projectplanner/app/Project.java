package com.group5.projectplanner.app;
import java.util.*;

public class Project {
	public int projectID;
	public String projectName;
	public Developer leader;
	public int startYear;
	public int end;
	public List<Activity> activities = new ArrayList<Activity> ();
	
	public void setID(int id) {
		this.projectID = id;
	}
	
	public void setName(String name) {
		this.projectName = name;
	}
	
	public void setStartYear(int start) {
		this.startYear = start;
	}
	
	public int getID() {
		return this.projectID;
	}
	
	public String getName() {
		return this.projectName;
	}
	
	public int getStartYear() {
		return this.startYear;
	}
	
	
	
	public boolean checkProjectLeader(Developer developer){
		if(this.leader == developer) {
			return true;
		}
		else {
			return false; 
		}
	}
	
	public void addActivity() {
		// adds activity to the activity list
	}
	
	public boolean checkActivityExist() {
		// Checks if an activity exists
		// return(developers.contains(developer));
		return true;
	}
	
	public void editActivityStartDate() {
		// Edits the start date of a given activity
	}
	
	public void editActivityEndDate() {
		
	}
	
	public void addDeveloperToActivity() {
		
	}
	
	public void setActivityComplete() {
		
	}
	
	public void checkIncompleteACtivities() {
		
	}
	
	public void setExpectedWorkHours() {
		
	}

}
