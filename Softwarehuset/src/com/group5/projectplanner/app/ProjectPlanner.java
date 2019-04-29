package com.group5.projectplanner.app;

import javax.xml.ws.Holder;

import java.util.Calendar;
import java.util.GregorianCalendar;

//Author: Casper Egholm Jørgensen (s163950)
public class ProjectPlanner {
	private Calendar calendar;
	private DeveloperCollection developers = new DeveloperCollection();
	private ProjectCollection projects = new ProjectCollection();

	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		developers.addDeveloper(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		//contains() uses object's equals() method
		return developers.checkDeveloperExist(developer);
	}
	
	//Author: Casper (s163950)
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExist(developer)){
			projects.addProject(project, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean checkProjectExist(Project project) {
		return projects.checkProjectExist(project);
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(Project project, Developer developer) throws Exception, FormattingException, OperationNotAllowedException {
		if(checkDeveloperExist(developer)){
			projects.setProjectLeader(project, developer);	
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean isProjectLeader(Project project, Developer developer){
		return projects.isProjectLeader(project, developer);
	}

	//Author: Casper (s163950)
	public void addActivity(ProjectActivity projectActivity, Project project, Developer developer) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(developer)){
			projects.addActivity(projectActivity, project, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	//Author: Casper (s163950)
	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException {
		return projects.checkActivityExists(projectActivity, project);
	}
	
	public void setStartYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			projects.setStartYear(project, year, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setStartWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			projects.setStartWeek(project, week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getStartWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		return projects.getStartWeek(project);
	}
	
	public int getStartYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	
		return projects.getStartYear(project);
	}
	
	public void setEndYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			projects.setEndYear(project, year, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setEndWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			projects.setEndWeek(project, week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getEndWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		return projects.getEndWeek(project);
	}
	
	public int getEndYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	
		return projects.getEndYear(project);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	/*
	public void assignDeveloper(ProjectActivity projectActivity, Project project, Developer devLeader, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException{
		if(checkDeveloperExist(devLeader) && checkDeveloperExist(assignedDeveloper)){
			projects.assignDeveloper(projectActivity, project, devLeader, assignedDeveloper);
		}
		
	}
	*/

	

