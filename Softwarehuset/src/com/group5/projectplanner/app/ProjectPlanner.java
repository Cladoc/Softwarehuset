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

	public void addActivity(ProjectActivity projectActivity, Project project, Developer developer) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(developer)){
			projects.addActivity(projectActivity, project, developer);
		}
	}

	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException {
		return projects.checkActivityExists(projectActivity, project);
	}
}
