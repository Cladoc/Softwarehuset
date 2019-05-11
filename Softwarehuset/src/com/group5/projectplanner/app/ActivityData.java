package com.group5.projectplanner.app;

public class ActivityData {
	private ActivityID activityID = new ActivityID();
	private DeveloperRepository developers = new DeveloperRepository();
	private Project parentProject;
	private double totalExpectedHours;
	private boolean complete;
	private int startYear;
	private int startWeek;
	private int endYear = 3000;
	private int endWeek;
	
	public ActivityData() {}
	
	public ActivityID getID() {
		return activityID;
	}
	
	public void setID(ActivityID activityID) {
		this.activityID = activityID;
	}
	
	public void setDevelopers(DeveloperRepository developers) {
		this.developers = developers;
	}
	
	public DeveloperRepository getDevelopers() {
		return this.developers;
	}
	
	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}
	
	public Project getParentProject() {
		return this.parentProject;
	}
	
	public void setExpectedWorkHours(double hours) {
			this.totalExpectedHours = hours;
	}
	
	public double getExpectedWorkHours() {
		return this.totalExpectedHours;
	}
	
	public void setCompleteness(boolean complete) {
		this.complete = complete;
	}
	
	public boolean getCompleteness() {
		return this.complete;
	}
	
	public int getStartYear() {
		return startYear;
	}
	
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	
	public int getStartWeek() {
		return startWeek;
	}
	
	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}
	
	public int getEndYear() {
		return endYear;
	}
	
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	public int getEndWeek() {
		return endWeek;
	}
	
	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
}