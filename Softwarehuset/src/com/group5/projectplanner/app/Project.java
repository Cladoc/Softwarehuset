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
	public void setStartYear(String start) throws Exception, FormattingException {
		int number = 0;
		try{
			
			number = Integer.parseInt(start);
			System.out.println("startYear is :" + this.startYear);
			System.out.println("endYear is :" + this.endYear);
			System.out.println("Number is :" + number);
			if(number < 1000 || number > 9999)
			{
				throw new FormattingException("Incorrect date format");
			}
			if(this.endYear < number) {
				throw new FormattingException("An invalid start date was entered");
			}
			this.startYear = number;
		}catch (Exception e){
			System.out.println("Im in the right place");
				throw new FormattingException("Incorrect date format");			
		}
	}
	
	@Override
	public void setStartWeek(String start) throws Exception, FormattingException {
		int number = 0;
		try{
			number = Integer.parseInt(start);
			if(number < 1 || number > 54)
			{
				
				System.out.println("startYear is :" + this.startYear);
				System.out.println("endYear is :" + this.endYear);
				System.out.println("Number is :" + number);
				throw new FormattingException("Incorrect date format");
			}
			if((this.startYear == this.endYear && this.endWeek <= number)) {
				throw new FormattingException("An invalid start date was entered");
			}
			this.startWeek = number;
		}catch (Exception e){
			throw new FormattingException("Incorrect date format");
			//System.out.println("Im here yo (aswell)!");
			/*if((this.startYear == this.endYear && this.endWeek <= number) && number >= 1 && number <= 54 ) {
				throw new FormattingException("An invalid start date was entered");
			}else {
				throw new FormattingException("Incorrect date format");
			}*/
			
		}
	}
	
	public void setEndYear(String start) throws Exception, FormattingException {
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
	}
	
	@Override
	public void setEndWeek(String start) throws Exception, FormattingException {
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
	}
	
	
	
	@Override
	public int getStartYear() {
		return this.startYear;
	}
	
	@Override
	public int getStartWeek() {
		return this.startWeek;
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

	public void addProjectActivity(ProjectActivity projectActivity) throws OperationNotAllowedException{
		activities.addActivity(projectActivity);
	}
	
	public boolean checkActivityExist(ProjectActivity projectActivity) {
		return activities.checkActivityExists(projectActivity);
	}


	/*
	public void assignDeveloper(ProjectActivity projectActivity, Developer devLeader, Developer assignedDeveloper) throws OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			activities.assignDeveloper(projectActivity, assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}
	*/
}
