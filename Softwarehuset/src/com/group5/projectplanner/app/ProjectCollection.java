package com.group5.projectplanner.app;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


//Author: Casper (s163950)
public class ProjectCollection {
	private int year = 0;
	private int serial = 0;
	private List<Project> projects = new ArrayList<>();
	
	//Author: Casper (s163950)
	public void addProject(Project project, Developer developer) throws OperationNotAllowedException {
		if(checkProjectExist(project)){
			throw new OperationNotAllowedException("A project with the specified name is already registered");
		}else{
			Integer projectID = computeProjectID();
			project.setID(projectID);
			projects.add(project);
		}
	}

	//Author: Casper (s163950)
	public boolean checkProjectExist(Project project) {
		if(!getProjectRef(project).isNil()){
			return true;
		}else{
			return false;
		}
	}
	
	//Author: Casper (s163950)
	public void setProjectLeader(Project project, Developer developer) throws OperationNotAllowedException, NullObjectException {
		AbstractProject abstProject = getProjectRef(project);
		abstProject.setProjectLeader(developer);
	}
	
	//Author: Casper (s163950)
	public boolean isProjectLeader(Project project, Developer developer){
		return getProjectRef(project).isProjectLeader(developer);
	}
	
	//Author: Casper (s163950)
	public void addProjectActivity(ProjectActivity projectActivity, Project project, Developer devLeader) throws NullObjectException, OperationNotAllowedException{
		AbstractProject abstProj = getProjectRef(project);
		abstProj.addProjectActivity(projectActivity, devLeader);
	}
	
	//Author: Casper (s163950)
	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException{
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.checkActivityExist(projectActivity);
	}
	
	
	public void assignDeveloper(ProjectActivity projectActivity, Project project, Developer devLeader,
			Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.assignDeveloper(projectActivity, devLeader, assignedDeveloper);
	}
	
	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Project project, Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.checkDeveloperAssigned(projectActivity, assignedDeveloper);
	}
	
	public void setExpectedHours(ProjectActivity projectActivity, Project project, Developer devLeader, String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setExpectedHours(projectActivity, devLeader, hours);
	}
	
	public double getExpectedHours(ProjectActivity projectActivity, Project project) throws NullObjectException{
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.getExpectedHours(projectActivity);
	}
	
	public void setActivityComplete(ProjectActivity projectActivity, Project project, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setActivityComplete(projectActivity, devLeader);
	}
	
	public boolean isActivityComplete(ProjectActivity projectActivity, Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.isActivityComplete(projectActivity);
	}
	
	public void setStartYear(Project project, String year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setStartYear(year);	
	}
	
	public void setStartWeek(Project project, String week, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setStartWeek(week, devLeader);
	}
	
	public int getStartWeek(Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.getStartWeek();	
	}
	
	public int getStartYear(Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.getStartYear();	
	}
	
	public void setEndYear(Project project, String year, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setEndYear(year, devLeader);	
	}
	
	public void setEndWeek(Project project, String week, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		abstProj.setEndWeek(week, devLeader);	
	}
	
	public int getEndWeek(Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.getEndWeek();	
	}
	
	public int getEndYear(Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		return abstProj.getEndYear();
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
		for(Project listProject : projects){
			if(listProject.equals(project)){
				return listProject;
			}
		}
		return new NullProject();
	}

}
