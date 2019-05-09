package com.group5.projectplanner.app;
import java.util.*;
import java.util.regex.Pattern;   
import java.util.regex.Matcher;  
public class Project extends AbstractProject {
	private ActivityRepository activityRepo = new ActivityRepository();
	private ProjectID projectID = new ProjectID();
	
	private Developer leader;
	private int startYear;
	private int startWeek;
	private int endYear = 3000;
	private int endWeek;
	
	//Strings used in error message
	private String invalidProjectName = "An invalid project name was entered";
	private String IDNotLeader = "ID not project leader";
	private String incorrectDate = "Incorrect date format";
	private String invalidStartDate = "An invalid start date was entered";
	private String invalidEndDate = "An invalid end date was entered";

	@Override
	public void setID(ProjectID projectID) {
		this.projectID = projectID;
	}
	
	@Override
	public ProjectID getID() {
		return this.projectID;
	}
	
	@Override
	public void setName(String name, Developer devLeader) throws OperationNotAllowedException, FormattingException {
		if(isProjectLeader(devLeader)){
			
			String regex = "\\A[a-zA-Z].*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(name);
			boolean b = matcher.matches();
			if(b) {
				this.projectID.setName(name);
			}else {
				throw new FormattingException(invalidProjectName);
			}
			
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}
	
	@Override
	public String getName() {
		return this.projectID.getName();
	}
	
	//Author: Casper (s163950)
	@Override
	public void setStartYear(String start) throws Exception, FormattingException, NullObjectException {
		
		int number = 0;
		try{
			number = Integer.parseInt(start);
			if(number < 1000 || number > 9999)
			{
				throw new FormattingException(incorrectDate);
			}
			if(this.endYear < number) {
				throw new FormattingException(invalidStartDate);
			}
			this.startYear = number;
		}catch (Exception e){
				throw new FormattingException(incorrectDate);			
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
					throw new FormattingException(incorrectDate);
				}
				if((this.startYear == this.endYear && this.endWeek <= number)) {
					throw new FormattingException(invalidStartDate);
				}
				this.startWeek = number;
			}catch (Exception e){
				throw new FormattingException(incorrectDate);
			}
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
		
	}
	
	public void setEndYear(String start, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			try{
				int number = Integer.parseInt(start);
				if(number < 1000 || number > 9999)
				{
					throw new FormattingException(incorrectDate);
				}
				if(this.startYear > number) {
					throw new FormattingException(invalidEndDate);
				}
				this.endYear = number;
			}catch (Exception e){
				throw new FormattingException(incorrectDate);
			}
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}
	
	@Override
	public void setEndWeek(String start, Developer devLeader) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			try{
				int number = Integer.parseInt(start);
				if(number < 1 || number > 54 )
				{
					throw new FormattingException(incorrectDate);
				}
				if((this.startYear == this.endYear && this.startWeek > number)) {
					throw new FormattingException(invalidEndDate);
				}
				this.endWeek = number;
			}catch (Exception e){
				throw new FormattingException(incorrectDate);
			}
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
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
	public prjData getProjectInformation(Developer devLeader) throws OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			prjData prjData = new prjData();
			prjData.setEndWeek(this.endWeek);
			prjData.setEndYear(this.endYear);
			prjData.setLeader(this.leader);
			prjData.setProjectID(this.projectID);
			prjData.setStartWeek(this.startWeek);
			prjData.setStartYear(this.startYear);
			return prjData;
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
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
		if(obj instanceof ProjectID){
			ProjectID projectID = (ProjectID) obj;
			return projectID.getName().equalsIgnoreCase(this.projectID.getName());
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
			activityRepo.addActivity(projectActivity, this);
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}
	
	public boolean checkActivityExists(ActivityID activityID) {
		return activityRepo.checkActivityExists(activityID);
	}

	public void assignDeveloper(ActivityID activityID, Developer devLeader, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(isProjectLeader(devLeader)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.assignDeveloper(assignedDeveloper);
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}

	public boolean checkDeveloperAssigned(ActivityID activityID, Developer assignedDeveloper) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.checkDeveloperAssigned(assignedDeveloper);
	}

	public void setExpectedHours(ActivityID activityID, Developer devLeader, String hours) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(devLeader)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setExpectedWorkHours(hours);
		}else{
			throw new OperationNotAllowedException("IDNotLeader");
		}
	}

	public double getExpectedHours(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.getExpectedWorkHours();
	}

	public void setActivityComplete(ActivityID activityID, Developer devLeader) throws NullObjectException, OperationNotAllowedException {
		if(isProjectLeader(devLeader)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setActivityComplete();
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}

	public boolean isActivityComplete(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.isActivityComplete();
	}

	@Override
	public List<ProjectActivity> getIncompleteActivities(Developer devLeader) 
			throws NullObjectException, OperationNotAllowedException {
		if (isProjectLeader(devLeader)) {
			return activityRepo.getIncompleteActivities();
		}else {
			throw new OperationNotAllowedException(IDNotLeader);
		}
		
	}
	
}
