package com.group5.projectplanner.app;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().equals(project)){
				return true;
			}
		}
		return false;
	}
	
	
	public void setProjectLeader(Project project, Developer developer) throws OperationNotAllowedException {
		boolean leaderSet = false;
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().getName().equalsIgnoreCase(project.getName())){
				entry.getKey().setProjectLeader(developer);
				leaderSet = true;
			}
		}
		if(!leaderSet){
			throw new OperationNotAllowedException("Project does not exist");
		}
	}
	
	public boolean isProjectLeader(Project project, Developer developer){
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().getName().equalsIgnoreCase(project.getName())){
				return entry.getKey().isProjectLeader(developer);
			}
		}
		return false;
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
