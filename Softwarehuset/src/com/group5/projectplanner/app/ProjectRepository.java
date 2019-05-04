package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//Author: Casper (s163950)
public class ProjectRepository {

	private int year = 0;
	private int serial = 0;
	private List<Project> projects = new ArrayList<>();
	
	public void addProject(Project project) throws OperationNotAllowedException {
		if(checkProjectExist(project.getID())){
			throw new OperationNotAllowedException("A project with the specified name is already registered");
		}else{
			ProjectID idToTest = project.getID();
			ProjectID newID = modifyProjectID(idToTest);
			project.setID(newID);
			projects.add(project);
		}
	}

	//Author: Casper (s163950)
	public boolean checkProjectExist(ProjectID projectID) {
		for(Project listProject : projects){
			if(listProject.getName().equalsIgnoreCase(projectID.getName())){
				return true;
			}
		}
		return false;
	}
	
	public AbstractProject getProjectRef(ProjectID projectID){
		
		for(Project listProject : projects){
			if(listProject.getName().equalsIgnoreCase(projectID.getName())){
				return listProject;
			}
		}
		return new NullProject();
	}

	//Internal helper methods
	private ProjectID modifyProjectID(ProjectID projectID){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(year < currentYear){
			serial = 0;
			year = currentYear;
		}
		projectID.setSerialNumber(serial);
		projectID.setYear(currentYear);
		serial++;
		return projectID;
	}
}
