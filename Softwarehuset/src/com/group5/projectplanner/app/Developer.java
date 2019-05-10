package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class Developer extends abstractDeveloper{
	private DeveloperID developerID  = new DeveloperID();
	private List<workHours> hoursWorked = new ArrayList<workHours>();
	
	public void setName(String name) {
		this.developerID.setName(name);
	}

	public String getName() {
		return this.developerID.getName();
	}
	
	public DeveloperID getDeveloperID(){
		return this.developerID;
	}
	
	public void registerHours(int week, int year, double hours, Activity activity) {
		workHours workHours = new workHours();
		workHours.setWeek(week);
		workHours.setYear(year);
		workHours.setHours(hours);
		workHours.setActivity(activity);
		hoursWorked.add(workHours);	
	}
	
	public double getHours(int week, int year) {
		double temp = 0;
		for(int i = 0; i < hoursWorked.size(); i++) {
			if(hoursWorked.get(i).getWeek() == week && hoursWorked.get(i).getYear() == year ) {
				temp += hoursWorked.get(i).getHours();
			}
		}
		return temp;
	}
	
	//Author: Casper (s163950)
	public boolean matches(DeveloperID developerID){
		return this.developerID.getName().equalsIgnoreCase(developerID.getName());
	}
	
	@Override
	public boolean isNil() {
		return false;
	}
}
