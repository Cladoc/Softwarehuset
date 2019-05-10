package com.group5.projectplanner.app;
import java.util.*;
import java.util.regex.Pattern;   
import java.util.regex.Matcher;  
public class Project extends AbstractProject {
	private ActivityRepository activityRepo = new ActivityRepository();
	private ProjectID projectID = new ProjectID();
	
	private DeveloperID leader;
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
	public DeveloperID getProjectLeader() {
		return this.leader;
	}
	
	@Override
	public void setName(String name, DeveloperID developerID) throws OperationNotAllowedException, FormattingException {
		if(isProjectLeader(developerID)){
			
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
	public void setStartWeek(String start, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(developerID)){
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
	
	public void setEndYear(String start, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(developerID)){
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
	public void setEndWeek(String start, DeveloperID developerID) throws Exception, FormattingException, OperationNotAllowedException {
		if(isProjectLeader(developerID)){
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
	public prjData getProjectInformation(DeveloperID developerID) throws OperationNotAllowedException {
		if(isProjectLeader(developerID)){
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

	public void setProjectLeader(DeveloperID developerID) {
		leader = developerID;
	}

	//Author: Casper (s163950)
	public boolean isProjectLeader(DeveloperID developerID) {
		if(leader == null){
			return false;
		}else{
			return leader.equals(developerID);
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
	public void addProjectActivity(ProjectActivity projectActivity, DeveloperID developerID) throws OperationNotAllowedException{
		if(isProjectLeader(developerID)){
			activityRepo.addActivity(projectActivity, this);
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}
	
	public boolean checkActivityExists(ActivityID activityID) {
		return activityRepo.checkActivityExists(activityID);
	}

	public void assignDeveloper(ActivityID activityID, DeveloperID developerID, Developer assignedDeveloper) throws OperationNotAllowedException, NullObjectException {
		if(isProjectLeader(developerID)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.assignDeveloper(assignedDeveloper);
		}else{
			throw new OperationNotAllowedException(IDNotLeader);
		}
	}

	public boolean checkDeveloperAssigned(ActivityID activityID, DeveloperID assignedDeveloperID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.checkDeveloperAssigned(assignedDeveloperID);
	}

	public void setExpectedHours(ActivityID activityID, DeveloperID developerID, String hours) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(developerID)){
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

	public void setActivityComplete(ActivityID activityID, DeveloperID developerID) throws NullObjectException, OperationNotAllowedException {
		if(isProjectLeader(developerID)){
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
	public List<ProjectActivity> getIncompleteActivities(DeveloperID developerID) 
			throws NullObjectException, OperationNotAllowedException {
		if (isProjectLeader(developerID)) {
			List<ProjectActivity> checklist = activityRepo.getIncompleteActivities();
			if (checklist.size() <= 0) {
				throw new OperationNotAllowedException("There are no incomplete activities");
			}
			else {
				return checklist;
			}
		}else {
			throw new OperationNotAllowedException(IDNotLeader);
		}
		
	}
	
	public Activity getProjectActivity(ActivityID activityID) {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity;
	}
	
	public void setActivityStartWeek(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(developerID)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setActivityStartWeek(week);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}
	
	
	public void setActivityStartYear(String year,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(developerID)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setActivityStartYear(year);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}
	
	public void setActivityEndWeek(String week,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(developerID)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setActivityEndWeek(week);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}
	
	
	public void setActivityEndYear(String year,ActivityID activityID, DeveloperID developerID) throws OperationNotAllowedException, FormattingException, NullObjectException {
		if(isProjectLeader(developerID)){
			Activity abstractActivity = activityRepo.getActivity(activityID);
			abstractActivity.setActivityEndYear(year);
		}else{
			throw new OperationNotAllowedException("Id is not leader");
		}
	}
	
	public int getActivityStartWeek(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.getActivityStartWeek();
	}
	
	public int getActivityStartYear(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.getActivityStartYear();
	}
	
	
	public int getActivityEndWeek(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.getActivityEndWeek();
	}
	
	public int getActivityEndYear(ActivityID activityID) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		return abstractActivity.getActivityEndYear();
	}

	@Override
	public void setActivityName(ActivityID activityID, String string) throws NullObjectException {
		Activity abstractActivity = activityRepo.getActivity(activityID);
		abstractActivity.setName(string);		
	}
}
