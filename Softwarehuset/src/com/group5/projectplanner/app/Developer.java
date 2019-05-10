package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class Developer extends abstractDeveloper{
	private DeveloperID developerID  = new DeveloperID();
	private List<workHours> hoursWorked = new ArrayList<workHours>();
	
	// Strings used for error messages
	private String incorrectInput = "Incorrect input";
	private String hourBoundary = "Input hours not within boundaries";
	private String invalidWeek = "Invalid week entered";
	private String invalidYear = "Invalid year entered";
	
	public void setName(String name) {
		this.developerID.setName(name);
	}

	public String getName() {
		return this.developerID.getName();
	}
	
	public DeveloperID getDeveloperID(){
		return this.developerID;
	}
	
	public void registerHours(String week, String year, String hours, Activity activity) throws FormattingException {
		workHours workHours = new workHours();
		int weekInteger = 0;
		int yearInteger = 0;
		double hoursDouble = 0.0;
		
		
		try{
			weekInteger = Integer.parseInt(week);
			yearInteger = Integer.parseInt(year);
			hoursDouble = Double.parseDouble(hours);
			workHours.setWeek(weekInteger);
			workHours.setYear(yearInteger);
			workHours.setHours(hoursDouble);
			workHours.setActivity(activity);
				
			if(weekInteger > 53 || weekInteger < 1) {		
				throw new FormattingException(invalidWeek);
			}else if(hoursDouble > 100 || hoursDouble < 0.0)
			{
				throw new FormattingException(hourBoundary);
			}else if(yearInteger >= 3000 || yearInteger < 2000)
			{
				throw new FormattingException(invalidYear);
			}else{
				
				hoursWorked.add(workHours);
			}
		
			
			
		}catch (Exception e){
				throw new FormattingException(incorrectInput);			
		}	
	}
	
		
		
	
	
	
	
	
	public double getHours(int week, int year) {
		double temp = 0;
		System.out.println("Week is :" + week + " year is :" + year);
		for(int i = 0; i < hoursWorked.size(); i++) {
			if(hoursWorked.get(i).getWeek() == week && hoursWorked.get(i).getYear() == year ) {
				
				temp = temp + hoursWorked.get(i).getHours();
				System.out.println("Iteration :"+ i + " temp is :" + temp);
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
