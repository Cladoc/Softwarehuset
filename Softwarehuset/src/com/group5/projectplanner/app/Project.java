package com.group5.projectplanner.app;
import java.util.*;

public class Project extends AbstractProject {
	private ActivityCollection activities = new ActivityCollection();
	private int projectID;
	private String projectName;
	private Developer leader;
	private int startYear;
	private int startWeek;
	private int endYear = 3000;
	private int endWeek;

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
	public void setStartYear(String start) throws Exception, FormattingException, NullObjectException {
		
		int number = 0;
		try{
			number = Integer.parseInt(start);
			if(number < 1000 || number > 9999)
			{
				throw new FormattingException("Incorrect date format");
			}
			if(this.endYear < number) {
				throw new FormattingException("An invalid start date was entered");
			}
			this.startYear = number;
		}catch (Exception e){
				throw new FormattingException("Incorrect date format");			
		}
		
	}
	
	@Override
	public void setStartWeek(String start, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			int number = 0;
			try{
				number = Integer.parseInt(start);
				if(number < 1 || number > 54)
				{
					throw new FormattingException("Incorrect date format");
				}
				if((this.startYear == this.endYear && this.endWeek <= number)) {
					throw new FormattingException("An invalid start date was entered");
				}
				this.startWeek = number;
			}catch (Exception e){
				throw new FormattingException("Incorrect date format");
			}
		}else{
			throw new OperationNotAllowedException("ID not project leader");
		}
		
	}
	
	public void setEndYear(String start, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			try{
				int number = Integer.parseInt(start);
				if(number < 1000 || number > 9999)
				{
					throw new FormattingException("Incorrect date format");
				}
				if(this.startYear > number) {
					throw new FormattingException("An invalid end date was entered");
				}
				this.endYear = number;
			}catch (Exception e){
				throw new FormattingException("Incorrect date format");
			}
		}else{
			throw new OperationNotAllowedException("ID not project leader");
		}
	}
	
	@Override
	public void setEndWeek(String start, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			try{
				int number = Integer.parseInt(start);
				if(number < 1 || number > 54 )
				{
					throw new FormattingException("Incorrect date format");
				}
				if((this.startYear == this.endYear && this.startWeek > number)) {
					throw new FormattingException("An invalid end date was entered");
				}
				this.endWeek = number;
			}catch (Exception e){
				throw new FormattingException("Incorrect date format");
			}
		}else{
			throw new OperationNotAllowedException("ID not project leader");
		}
	}
	
	
	
	@Override
	public int getStartYear() {
		return this.startYear;
	}
	
	@Override
	public int getStartWeek() {
		return this.startWeek;
	}
	
	@Override
	public String getProjectInformation(Developer devLeader) throws OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			return "project information";
		}else{
			throw new OperationNotAllowedException("ID not project leader");
		}
	}
	
	public int getEndYear() {
		return this.endYear;
	}
	
	@Override
	public int getEndWeek() {
		return this.endWeek;
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

	@Override
	public void addProjectActivity(ProjectActivity projectActivity, Developer devLeader) throws OperationNotAllowedException{
		if(isProjectLeader(devLeader)){
			activities.addActivity(projectActivity);
		}else{
			throw new OperationNotAllowedException("ID not project leader");
		}
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

	public void setExpectedHours(ProjectActivity projectActivity, Developer devLeader, String hours) throws OperationNotAllowedException, FormattingException, NullObjectException {
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
