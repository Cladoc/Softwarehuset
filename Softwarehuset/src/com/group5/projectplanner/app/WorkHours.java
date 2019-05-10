package com.group5.projectplanner.app;

public class WorkHours {
	private int week;
	private int year;
	private double hours;
	private AbstractActivity activity;
	
	public WorkHours() {}
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	
	public AbstractActivity getActivity() {
		return activity;
	}
	public void setActivity(AbstractActivity activity) {
		this.activity = activity;
	}
	
}
