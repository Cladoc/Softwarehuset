package com.group5.projectplanner.app;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class ProjectPlanner {
	private Calendar calendar;
	private List<Developer> developers = new ArrayList<>(); //list of developers
	private Map<Project, Integer> projectMapping = new HashMap<Project, Integer>(); 
	private int serial = 0;
	private int year = 0;
	
	public void addDeveloper(Developer developer) {
		developers.add(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		return(developers.contains(developer));
	}
	
	public void addProject(Project project) {
		Integer projectID = computeProjectID();
		projectMapping.put(project, projectID);
		System.out.println(projectMapping.get(project));
	}
	
	public boolean checkProjectExist(Project project) {
		return projectMapping.containsKey(project);
	}
	
	Integer computeProjectID(){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR); 
		if(year < currentYear){
			serial = 0;
			year = currentYear;
		}
		int number = currentYear*100 + serial;
		serial++;
		Integer projectID = new Integer(number);
		return projectID;
	}
	
}
