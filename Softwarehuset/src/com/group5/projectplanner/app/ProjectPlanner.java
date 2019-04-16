package com.group5.projectplanner.app;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

//Author: Casper Egholm J�rgensen (s163950)
public class ProjectPlanner {
	private Calendar calendar;
	private List<Developer> developers = new ArrayList<>(); //list of developers
	private Map<Project, Integer> projectMapping = new HashMap<Project, Integer>(); 
	private int serial = 0;
	private int year = 0;
	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExist(developer)){
			throw new OperationNotAllowedException("ID already exists");
		}else{
			developers.add(developer);
		}
		
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		//contains() uses object's equals() method
		return developers.contains(developer);
	}
	
	//Author: Casper (s163950)
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExist(developer)){
			if(projectAlreadyExists(project.getName())){
				throw new OperationNotAllowedException("A project with the specified name is already registered");
			}else{
				Integer projectID = computeProjectID();
				projectMapping.put(project, projectID);
			}
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean checkProjectExist(Project project) {
		return projectMapping.containsKey(project);
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(Project project, Developer developer) throws Exception, FormattingException, OperationNotAllowedException {
		if(checkDeveloperExist(developer)){
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
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean isProjectLeader(Project project, Developer developer) throws Exception, FormattingException {
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().getName().equalsIgnoreCase(project.getName())){
				return entry.getKey().isProjectLeader(developer);
			}
		}
		return false;
	}
	
	
	//Internal methods:----------------------------------
	//Author: Anders (s163952)
		private Integer computeProjectID(){
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
	
	
	
	//Helper methods:------------------------------------
	
	//Author: Casper (s163950)
	private boolean projectAlreadyExists(String name){
		for(Map.Entry<Project, Integer> entry : projectMapping.entrySet()){
			if(entry.getKey().getName().equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}


}
