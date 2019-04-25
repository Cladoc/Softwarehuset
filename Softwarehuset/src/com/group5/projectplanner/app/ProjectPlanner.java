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

	
	public void assignDeveloper(ProjectActivity projectActivity, Project project, Developer devLeader, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException{
		if(checkDeveloperExist(devLeader) && checkDeveloperExist(assignedDeveloper)){
			projects.assignDeveloper(projectActivity, project, devLeader, assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
		
	}

	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Project project, Developer testDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(testDeveloper)){
			return projects.checkDeveloperAssigned(projectActivity, project, testDeveloper);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setExpectedHours(ProjectActivity projectActivity, Project project, Developer devLeader,
			String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			projects.SetExpectedHours(projectActivity, project, devLeader, hours);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public double getExpectedHours(ProjectActivity projectActivity, Project project) throws NullObjectException {
		return projects.getExpectedHours(projectActivity, project);
	}
	
}
