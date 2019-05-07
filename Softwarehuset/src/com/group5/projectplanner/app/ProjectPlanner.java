package com.group5.projectplanner.app;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//Author: Casper Egholm Jørgensen (s163950)
public class ProjectPlanner {
	//private Developer currentSignedInDeveloper;
	private DeveloperRepository devRepo = new DeveloperRepository();
	private ProjectRepository projectsRepo = new ProjectRepository();
	//private Project currentWorkingProject;
	//private ProjectActivity currentWorkingActivity;

	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.addDeveloper(developer);
	}
	
	public void removeDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.removeDeveloper(developer);
	}
	
	public boolean checkDeveloperExist(Developer developer) {
		//contains() uses object's equals() method
		return devRepo.checkDeveloperExists(developer);
	}
	
	//Author: Casper (s163950)
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExist(developer)){
			projectsRepo.addProject(project);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean checkProjectExist(ProjectID projectID) {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return !proj.isNil();
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(ProjectID projectID, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setProjectLeader(developer);	
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public boolean isProjectLeader(ProjectID projectID, Developer developer){
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.isProjectLeader(developer);
	}

	//Author: Casper (s163950)
	public void addProjectActivity(ProjectActivity projectActivity, ProjectID projectID, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.addProjectActivity(projectActivity, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void assignDeveloper(ActivityID activityID, ProjectID projectID, Developer devLeader, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException{
		if(checkDeveloperExist(devLeader) && checkDeveloperExist(assignedDeveloper)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.assignDeveloper(activityID, devLeader, assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
		
	}

	public boolean checkDeveloperAssigned(ActivityID activityID, ProjectID projectID, Developer testDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(testDeveloper)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			return proj.checkDeveloperAssigned(activityID, testDeveloper);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setExpectedHours(ActivityID activityID, ProjectID projectID, Developer devLeader,
			String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setExpectedHours(activityID, devLeader, hours);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public double getExpectedHours(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getExpectedHours(activityID);
	}

	public void setActivityComplete(ActivityID activityID, ProjectID projectID, Developer devLeader) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityComplete(activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public boolean isActivityComplete(ActivityID activityID, ProjectID ProjectID, Developer devLeader) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(ProjectID);
		return proj.isActivityComplete(activityID);
	}
	
	//Author: Casper (s163950)
	public boolean checkActivityExists(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.checkActivityExists(activityID);
	}
	
	public void setStartYear(ProjectID projectID, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setStartYear(year);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setStartWeek(ProjectID projectID, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setStartWeek(week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getStartWeek(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getStartWeek();
	}
	
	public int getStartYear(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getStartYear();
	}
	
	public void setEndYear(ProjectID projectID, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setEndYear(year, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}

	public void setEndWeek(ProjectID projectID, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developer)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setEndWeek(week, developer);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	public int getEndWeek(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getEndWeek();
	}
	
	public int getEndYear(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getEndYear();
	}
	
	public String getProjectName(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getName();
	}
	
	public prjData getProjectInformation(ProjectID projectID, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getProjectInformation(devLeader);
	}
	
	public void editProjectName(ProjectID projectID, Developer devLeader, String name) throws OperationNotAllowedException, FormattingException {
		
		if(checkDeveloperExist(devLeader)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setName(name, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
	}
	
	
	
	
	
	
	
	
	
}

