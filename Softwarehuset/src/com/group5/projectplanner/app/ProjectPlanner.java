package com.group5.projectplanner.app;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//Author: Casper Egholm Jørgensen (s163950)
public class ProjectPlanner {
	private Calendar calendar;
	private DeveloperRepository devRepo = new DeveloperRepository();
	private ProjectRepository projectsRepo = new ProjectRepository();

	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.addDeveloper(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		//contains() uses object's equals() method
		return devRepo.checkDeveloperExists(developer);
	}
	
	//Author: Casper (s163950)
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExist(developer)){
			projectsRepo.addProject(project, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean checkProjectExist(Project project) {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return !proj.isNil();
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(Project project, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setProjectLeader(developer);	
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean isProjectLeader(Project project, Developer developer){
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.isProjectLeader(developer);
	}

	//Author: Casper (s163950)
	public void addProjectActivity(ProjectActivity projectActivity, Project project, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.addProjectActivity(projectActivity, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void assignDeveloper(ProjectActivity projectActivity, Project project, Developer devLeader, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException{
		if(checkDeveloperExist(devLeader) && checkDeveloperExist(assignedDeveloper)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.assignDeveloper(projectActivity, devLeader, assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
		
	}

	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Project project, Developer testDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(testDeveloper)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			return proj.checkDeveloperAssigned(projectActivity, testDeveloper);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setExpectedHours(ProjectActivity projectActivity, Project project, Developer devLeader,
			String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setExpectedHours(projectActivity, devLeader, hours);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public double getExpectedHours(ProjectActivity projectActivity, Project project) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getExpectedHours(projectActivity);
	}

	public void setActivityComplete(ProjectActivity projectActivity, Project project, Developer devLeader) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setActivityComplete(projectActivity, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public boolean isActivityComplete(ProjectActivity projectActivity, Project project, Developer devLeader) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.isActivityComplete(projectActivity);
		
	}
	
	//Author: Casper (s163950)
	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.checkActivityExists(projectActivity);
	}
	
	public void setStartYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setStartYear(year);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setStartWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setStartWeek(week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getStartWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getStartWeek();
	}
	
	public int getStartYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getStartYear();
	}
	
	public void setEndYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setEndYear(year, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setEndWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(project);
			proj.setEndWeek(week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getEndWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getEndWeek();
	}
	
	public int getEndYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getEndYear();
	}
	
	public String getProjectInformation(Project project, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(project);
		return proj.getProjectInformation(devLeader);
	}
	
	
	
	
	
	
	
	
	
	
}

