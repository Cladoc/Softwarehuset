package com.group5.projectplanner.app;
import java.util.List;
import java.util.ArrayList;


//import Developer
//import Project

public class ProjectPlanner {
	private List<Developer> developers = new ArrayList<>(); //list of developers
	//List projects //list of projects
	public void addDeveloper(Developer developer) {
		developers.add(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		return(developers.contains(developer));
	}
	
	public static void addProject() {
		
	}
	public static void checkProjectExist() {
		
	}
	
}
