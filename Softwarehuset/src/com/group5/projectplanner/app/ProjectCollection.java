package com.group5.projectplanner.app;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//Author: Casper (s163950)
public class ProjectCollection {
	private int year = 0;
	private int serial = 0;
	private Map<Project, Integer> projectMapping = new HashMap<Project, Integer>(); //Swap key and value for semantics?

	public void addProject(Project project, Developer developer) throws OperationNotAllowedException {
		// TODO Auto-generated method stub
		if(checkProjectExist(project)){
			throw new OperationNotAllowedException("A project with the specified name is already registered");
		}else{
			Integer projectID = computeProjectID();
			projectMapping.put(project, projectID);
		}
	}

	public boolean checkProjectExist(Project project) {
		if(!getProjectRef(project).isNil()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void setProjectLeader(Project project, Developer developer) throws OperationNotAllowedException {
		AbstractProject projectToTest = getProjectRef(project);
		if(!projectToTest.isNil()){
			projectToTest.setProjectLeader(developer);
		}else{
			throw new OperationNotAllowedException("Project does not exist");
		}
	}
	
	public boolean isProjectLeader(Project project, Developer developer){
		return getProjectRef(project).isProjectLeader(developer);
	}
	
	public void addActivity(ProjectActivity projectActivity, Project project, Developer developer) throws NullObjectException, OperationNotAllowedException{
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			proj.addProjectActivity(projectActivity);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException{
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.checkActivityExist(projectActivity);
		}else{
			throw new NullObjectException("Project does not exist");
		}
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
	
	private AbstractProject getProjectRef(Project project){
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().equals(project)){
				return entry.getKey();
			}
		}
		return new NullProject();
	}

	

	

	
}
