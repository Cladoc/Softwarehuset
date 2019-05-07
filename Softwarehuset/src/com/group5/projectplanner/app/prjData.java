package com.group5.projectplanner.app;

public class prjData {
	private ProjectID projectID = new ProjectID();
	private Developer leader;
	private int startYear;
	private int startWeek;
	private int endYear = 3000;
	private int endWeek;
	
	public prjData() {}
	
	public ProjectID getProjectID() {
		return projectID;
	}
	public void setProjectID(ProjectID projectID) {
		this.projectID = projectID;
	}
	
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public Developer getLeader() {
		return leader;
	}
	public void setLeader(Developer leader) {
		this.leader = leader;
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
