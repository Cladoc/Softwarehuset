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
	public void addActivity(ProjectActivity projectActivity, Project project, Developer developer) throws NullObjectException, OperationNotAllowedException{
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			if(proj.isProjectLeader(developer)){
				proj.addProjectActivity(projectActivity);
			}else{
				throw new OperationNotAllowedException("ID not project leader");
			}
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	//Author: Casper (s163950)
	public boolean checkActivityExists(ProjectActivity projectActivity, Project project) throws NullObjectException{
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.checkActivityExist(projectActivity);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	
	public void assignDeveloper(ProjectActivity projectActivity, Project project, Developer devLeader,
			Developer assignedDeveloper) throws NullObjectException, OperationNotAllowedException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			proj.assignDeveloper(projectActivity, devLeader, assignedDeveloper);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Project project, Developer assignedDeveloper) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.checkDeveloperAssigned(projectActivity, assignedDeveloper);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public void setExpectedHours(ProjectActivity projectActivity, Project project, Developer devLeader, String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			proj.setExpectedHours(projectActivity, devLeader, hours);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public double getExpectedHours(ProjectActivity projectActivity, Project project) throws NullObjectException{
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.getExpectedHours(projectActivity);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public void setActivityComplete(ProjectActivity projectActivity, Project project, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			proj.setActivityComplete(projectActivity, devLeader);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public boolean isActivityComplete(ProjectActivity projectActivity, Project project) throws NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.isActivityComplete(projectActivity);
		}else{
			throw new NullObjectException("Project does not exist");
		}
	}
	
	public void setStartYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			if(proj.isProjectLeader(developer)){
				proj.setStartYear(year);
			}else{
				throw new OperationNotAllowedException("ID not project leader");
			}
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public void setStartWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			if(proj.isProjectLeader(developer)){
				proj.setStartWeek(week);
			}else{
				throw new OperationNotAllowedException("ID not project leader");
			}
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public int getStartWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.getStartWeek();
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public int getStartYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.getStartYear();
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public void setEndYear(Project project, String year, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			if(proj.isProjectLeader(developer)){
				proj.setEndYear(year);
			}else{
				throw new OperationNotAllowedException("ID not project leader");
			}
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public void setEndWeek(Project project, String week, Developer developer) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			if(proj.isProjectLeader(developer)){
				proj.setEndWeek(week);
			}else{
				throw new OperationNotAllowedException("ID not project leader");
			}
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public int getEndWeek(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.getEndWeek();
		}else{
			throw new NullObjectException("Project does not exist");
		}	
	}
	
	public int getEndYear(Project project) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		AbstractProject abstProj = getProjectRef(project);
		if(!abstProj.isNil()){
			Project proj = (Project) abstProj;
			return proj.getEndYear();
		}else{
			throw new NullObjectException("Project does not exist");
		}	
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

	
	//doWithObject(projectId, p => p.setProjectLeder(developer));
    //doWithObject(projectId, new AbstractChange() { public void change(AbstractProject p) { p.setProjectLeader(developer) });
//	AbstractProject project = getProject(projectId);
//  project.setProjectLeader(developer);
	
}
