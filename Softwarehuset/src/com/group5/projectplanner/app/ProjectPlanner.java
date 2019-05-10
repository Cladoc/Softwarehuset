package com.group5.projectplanner.app;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//Author: Casper Egholm Jørgensen (s163950)
public class ProjectPlanner {
	
	private DeveloperRepository devRepo = new DeveloperRepository();
	private ProjectRepository projectsRepo = new ProjectRepository();
	String invalidID = "Invalid ID";
	
	public void registerHours(int week, int year, double hours, ActivityID activityID, DeveloperID developerID, ProjectID projectID) throws NullObjectException {
		abstractDeveloper dev = devRepo.getDeveloper(developerID);
		AbstractProject proj = projectsRepo.getProjectRef(projectID);		
		dev.registerHours(week, year, hours, proj.getProjectActivity(activityID));
	}
	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.addDeveloper(developer);
	}
	
	public DeveloperID getProjectLeader(ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getProjectLeader();
	}
	
	public void removeDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.removeDeveloper(developer);
	}
	
	public boolean checkDeveloperExist(DeveloperID developerID) {
		return devRepo.checkDeveloperExists(developerID);
	}
	
	//Author: Casper (s163950)
	public void addProject(Project project, DeveloperID developerID) throws OperationNotAllowedException{
		if(checkDeveloperExist(developerID)){
			projectsRepo.addProject(project);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}
	
	public boolean checkProjectExist(ProjectID projectID) {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return !proj.isNil();
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(ProjectID projectID, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setProjectLeader(developerID);	
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}
	
	public boolean isProjectLeader(ProjectID projectID, DeveloperID developerID){
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.isProjectLeader(developerID);
	}

	//Author: Casper (s163950)
	public void addProjectActivity(ProjectActivity projectActivity, ProjectID projectID, DeveloperID developerID) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.addProjectActivity(projectActivity, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void assignDeveloper(ActivityID activityID, ProjectID projectID, DeveloperID developerID, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException{
		if(checkDeveloperExist(developerID) && checkDeveloperExist(assignedDeveloper.getDeveloperID())){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.assignDeveloper(activityID, developerID, assignedDeveloper);
			//////////////////////////////////////////////////////////////////7
			/////////////////////////////////////////////////////////7
			///////////////////////////////////////////////////////77
		}else{
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
		
	}

	public boolean checkDeveloperAssigned(ActivityID activityID, ProjectID projectID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			return proj.checkDeveloperAssigned(activityID, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setExpectedHours(ActivityID activityID, ProjectID projectID, DeveloperID developerID,
			String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setExpectedHours(activityID, developerID, hours);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public double getExpectedHours(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getExpectedHours(activityID);
	}

	public void setActivityComplete(ActivityID activityID, ProjectID projectID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityComplete(activityID, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
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
	
	public void setStartYear(ProjectID projectID, String year, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setStartYear(year);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setStartWeek(ProjectID projectID, String week, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setStartWeek(week, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
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
	
	public void setEndYear(ProjectID projectID, String year, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setEndYear(year, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setEndWeek(ProjectID projectID, String week, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setEndWeek(week, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
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
	
	public prjData getProjectInformation(ProjectID projectID, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getProjectInformation(developerID);
	}
	
	public void editProjectName(ProjectID projectID, DeveloperID developerID, String name) throws OperationNotAllowedException, FormattingException {
		
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setName(name, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public List<ProjectActivity> getIncompleteActivities(ProjectID projectID, DeveloperID developerID) 
			throws OperationNotAllowedException, NullObjectException {		
		if (checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			return proj.getIncompleteActivities(developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	
	public void setActivityStartWeek(String week, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityStartWeek(week, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public void setActivityStartYear(String year, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityStartYear(year, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}
	
	public void setActivityEndWeek(String week, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityEndWeek(week, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public void setActivityEndYear(String year, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProjectRef(projectID);
			proj.setActivityEndYear(year, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public int getActivityStartWeek(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getActivityStartWeek(activityID);
	}
	
	public int getActivityStartYear(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getActivityStartYear(activityID);
	}
	
	public int getActivityEndYear(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getActivityEndYear(activityID);
	}
	
	public int getActivityEndWeek(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		return proj.getActivityEndWeek(activityID);
	}

	public void setActivityName(ActivityID activityID, ProjectID projectID, String string) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProjectRef(projectID);
		proj.setActivityName(activityID, string);
	}
	
	
	
}

