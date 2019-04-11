package com.group5.projectplanner.app;
import java.util.List;
import java.util.ArrayList;


//import Developer
//import Project

public class ProjectPlanner {
	private List<Developer> developers = new ArrayList<>(); //list of developers
	private List<Project> projects = new ArrayList<>();//List projects //list of projects
	public void addDeveloper(Developer developer) {
		developers.add(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		return(developers.contains(developer));
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	public boolean checkProjectExist(Project project) {
		return(projects.contains(project));
	}
	
}
