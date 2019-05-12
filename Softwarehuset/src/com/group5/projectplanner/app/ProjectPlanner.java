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
	
	public void registerHours(String week, String year, String hours, ActivityID activityID, DeveloperID developerID, ProjectID projectID) 
			throws NullObjectException, FormattingException {
		AbstractDeveloper dev = devRepo.getDeveloper(developerID);
		AbstractProject proj = projectsRepo.getProject(projectID);		
		dev.registerHours(week, year, hours, proj.getProjectActivity(activityID));
	}

	public List<DeveloperID> getAvailableDevelopers(String week, String year) throws FormattingException {
		return devRepo.getAvailableDevelopers(week, year);
	}

	public double getHours(int week, int year, DeveloperID developerID) throws NullObjectException {
		AbstractDeveloper dev = devRepo.getDeveloper(developerID);
		return dev.getHours(week, year);
	}
	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		devRepo.addDeveloper(developer);
	}
	
	public DeveloperID getProjectLeader(ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getProjectLeader();
	}
	public void removeDeveloper(DeveloperID devID) throws OperationNotAllowedException {
		if (checkDeveloperExist(devID)) {
			AbstractDeveloper abstractDeveloper = devRepo.getDeveloper(devID);
			Developer developer = (Developer) abstractDeveloper;
			developer.unAssignDeveloper();
			devRepo.removeDeveloper(developer);
		} else {
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
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
		AbstractProject proj = projectsRepo.getProject(projectID);
		return !proj.isNil();
	}
	

	//Author: Casper (s163950)
	public void setProjectLeader(ProjectID projectID, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setProjectLeader(developerID);	
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}
	
	public boolean isProjectLeader(ProjectID projectID, DeveloperID developerID){
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.isProjectLeader(developerID);
	}

	//Author: Casper (s163950)
	public void addProjectActivity(Activity projectActivity, ProjectID projectID, DeveloperID developerID) throws NullObjectException, OperationNotAllowedException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.addProjectActivity(projectActivity, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void assignDeveloper(ActivityID activityID, ProjectID projectID, DeveloperID devLeaderID,
			DeveloperID devIDToAssign) throws NullObjectException, OperationNotAllowedException {
		if (checkDeveloperExist(devLeaderID) && checkDeveloperExist(devIDToAssign)) {
			AbstractDeveloper abstractDeveloper = devRepo.getDeveloper(devIDToAssign);
			AbstractProject proj = projectsRepo.getProject(projectID);
			Developer developer = (Developer) abstractDeveloper;
			proj.assignDeveloper(activityID, devLeaderID, developer);
		} else {
			throw new OperationNotAllowedException("Developer not registered in project planner");
		}
		
	}

	public boolean checkDeveloperAssigned(ActivityID activityID, ProjectID projectID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			return proj.checkDeveloperAssigned(activityID, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setExpectedHours(ActivityID activityID, ProjectID projectID, DeveloperID developerID,
			String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setExpectedHours(activityID, developerID, hours);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public double getExpectedHours(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getExpectedHours(activityID);
	}

	public void setActivityComplete(ActivityID activityID, ProjectID projectID, DeveloperID developerID) throws OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityComplete(activityID, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public boolean isActivityComplete(ActivityID activityID, ProjectID ProjectID, Developer devLeader) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(ProjectID);
		return proj.isActivityComplete(activityID);
	}
	
	//Author: Casper (s163950)
	public boolean checkActivityExists(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.checkActivityExists(activityID);
	}
	
	public void setStartYear(ProjectID projectID, String year, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setStartYear(year);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setStartWeek(ProjectID projectID, String week, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setStartWeek(week, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}
	
	public int getStartWeek(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getStartWeek();
	}
	
	public int getStartYear(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getStartYear();
	}
	
	public void setEndYear(ProjectID projectID, String year, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setEndYear(year, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public void setEndWeek(ProjectID projectID, String week, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setEndWeek(week, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}
	
	public int getEndWeek(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {	
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getEndWeek();
	}
	
	public int getEndYear(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getEndYear();
	}
	
	public String getProjectName(ProjectID projectID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getName();
	}
	
	public ProjectData getProjectInformation(ProjectID projectID, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getProjectInformation(developerID);
	}
	
	public void editProjectName(ProjectID projectID, DeveloperID developerID, String name) throws OperationNotAllowedException, FormattingException {
		
		if(checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setName(name, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public List<Activity> getIncompleteActivities(ProjectID projectID, DeveloperID developerID) 
			throws OperationNotAllowedException, NullObjectException {		
		if (checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			return proj.getIncompleteActivities(developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	
	public void setActivityStartWeek(String week, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityStartWeek(week, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public void setActivityStartYear(String year, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityStartYear(year, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}
	
	public void setActivityEndWeek(String week, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityEndWeek(week, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public void setActivityEndYear(String year, ActivityID activityID, ProjectID projectID, DeveloperID devLeader) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(checkDeveloperExist(devLeader)){
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityEndYear(year, activityID, devLeader);
		}else{
			throw new OperationNotAllowedException("Invalid ID");
		}
		
	}

	public int getActivityStartWeek(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getActivityStartWeek(activityID);
	}
	
	public int getActivityStartYear(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getActivityStartYear(activityID);
	}
	
	public int getActivityEndYear(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getActivityEndYear(activityID);
	}
	
	public int getActivityEndWeek(ActivityID activityID, ProjectID projectID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getActivityEndWeek(activityID);
	}

	public List<ProjectID> getProjectIDs() {
		return projectsRepo.getProjectIDs();
	}

	public List<ActivityID> getActivityIDs(ProjectID selectedProjectID, DeveloperID signedInDeveloperID) throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(selectedProjectID);
		return proj.getActivityIDs();
		
	}

	public void setActivityName(ActivityID activityID, ProjectID projectID, String name, DeveloperID developerID) 
			throws NullObjectException, FormattingException, OperationNotAllowedException {
		if (checkDeveloperExist(developerID)) {
			AbstractProject proj = projectsRepo.getProject(projectID);
			proj.setActivityName(activityID, name, developerID);
		}else{
			throw new OperationNotAllowedException(invalidID);
		}
	}

	public ActivityData getActivityInformation(ProjectID projectID, ActivityID activityID, DeveloperID developerID)
			throws NullObjectException {
		AbstractProject proj = projectsRepo.getProject(projectID);
		return proj.getActivityInformation(activityID, developerID);
	}

}

