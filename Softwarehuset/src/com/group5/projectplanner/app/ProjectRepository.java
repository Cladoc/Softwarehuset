package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProjectRepository {

	private int year = 0;
	private int serial = 0;
	private List<Project> projects = new ArrayList<>();
	
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException {
		if(checkProjectExist(project)){
			throw new OperationNotAllowedException("A project with the specified name is already registered");
		}else{
			Integer projectID = computeProjectID();
			project.setID(projectID);
			projects.add(project);
		}
	}

	//Author: Casper (s163950)
	public boolean checkProjectExist(Project project) {
		//Uses object's equals() method
		return projects.contains(project);
	}
	
	public AbstractProject getProjectRef(Project project){
		for(Project listProject : projects){
			if(listProject.equals(project)){
				return listProject;
			}
		}
		return new NullProject();
	}

	//Internal helper methods
	private int computeProjectID(){
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
