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
	
	public ActivityID getActivityID() {
		return activityID;
	}
	
	public void setActivityID(ActivityID activityID) {
		this.activityID = activityID;
	}
	
	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}
	
	public void setExpectedWorkHours(double hours) {
			this.totalExpectedHours = hours;
	}
	
	public double getExpectedWorkHours() {
		return this.totalExpectedHours;
	}
	
	public void setActivityCompleteness(boolean complete) {
		this.complete = complete;
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
