package com.group5.projectplanner.app;
import java.util.*;

public class Project extends AbstractProject {
	private ActivityCollection activities = new ActivityCollection();
	private int projectID;
	private String projectName;
	private Developer leader;
	private int startYear;

	@Override
	public void setID(int id) {
		this.projectID = id;
	}
	
	@Override
	public int getID() {
		return this.projectID;
	}
	
	@Override
	public void setName(String name) {
		this.projectName = name;
	}
	
	@Override
	public String getName() {
		return this.projectName;
	}
	
	//Author: Casper (s163950)
	@Override
	public void setStartYear(String start) throws Exception, FormattingException {
		try{
			int number = Integer.parseInt(start);
			if(number < 1000 || number > 9999)
			{
				throw new FormattingException("Incorrect date format");
			}
			this.startYear = number;
		}catch (Exception e){
			throw new FormattingException("Incorrect date format");
		}
	}
	
	@Override
	public int getStartYear() {
		return this.startYear;
	}

	public void setProjectLeader(Developer developer) {
		leader = developer;
	}

	//Author: Casper (s163950)
	public boolean isProjectLeader(Developer developer) {
		if(leader == null){
			return false;
		}else{
			return leader.equals(developer);
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Project){
			Project proj = (Project) obj;
			return this.projectName.equalsIgnoreCase(proj.getName());
		}else{
			return false;
		}
	}
	
	@Override
	public boolean isNil(){
		return false;
	}

	public void addProjectActivity(ProjectActivity projectActivity) throws OperationNotAllowedException{
		activities.addActivity(projectActivity);
	}
	
	public boolean checkActivityExist(ProjectActivity projectActivity) {
		return activities.checkActivityExists(projectActivity);
	}


	
	public void assignDeveloper(ProjectActivity projectActivity, Developer devLeader, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(isProjectLeader(devLeader)){
			activities.assignDeveloper(projectActivity, assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}

	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Developer assignedDeveloper) throws NullObjectException {
		return activities.checkDeveloperAssigned(projectActivity, assignedDeveloper);
	}

	public void setExpectedHours(ProjectActivity projectActivity, Developer devLeader, String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
		if(isProjectLeader(devLeader)){
			activities.setExpectedHours(projectActivity, hours);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}

	public double getExpectedHours(ProjectActivity projectActivity) throws NullObjectException {
		return activities.getExpectedHours(projectActivity);
	}

	public void setActivityComplete(ProjectActivity projectActivity, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			activities.setActivityComplete(projectActivity);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}

	public boolean isActivityComplete(ProjectActivity projectActivity) throws NullObjectException {
		return activities.isActivityComplete(projectActivity);
	}
	
}
