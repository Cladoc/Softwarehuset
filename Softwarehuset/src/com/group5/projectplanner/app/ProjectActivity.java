package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends Activity {
	private ActivityID activityID = new ActivityID();
	private String name = "";
	private DeveloperRepository developers = new DeveloperRepository();
	private Project parentProject;
	private double totalExpectedHours;
	private boolean complete = false;
	
	public ProjectActivity(){}
	public ProjectActivity(ActivityID activityID) {
		this.activityID = activityID;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Activity){
			Activity act = (Activity) obj;
			return this.activityID.getName().equalsIgnoreCase(act.getName());
		}else{
			return false;
		}
	}

	@Override
	public void setName(String name) {
		this.activityID.setName(name);
	}


	@Override
	public String getName() {
		return this.activityID.getName();
	}

	public void setID(ActivityID activityID){
		this.activityID = activityID;
	}
	
	public ActivityID getID(){
		return this.activityID;
	}

	@Override
	public boolean isNil() {
		return false;
	}


	public void assignDeveloper(Developer assignedDeveloper) throws OperationNotAllowedException {
		if(!developers.checkDeveloperExists(assignedDeveloper.getDeveloperID()))
		{
			developers.addDeveloper(assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer already assigned");
		}
	}


	public boolean checkDeveloperAssigned(DeveloperID assignedDeveloperID) {
		return developers.checkDeveloperExists(assignedDeveloperID);
	}


	public void setExpectedWorkHours(String hours) throws FormattingException{
		try{
			this.totalExpectedHours = Double.valueOf(hours);
		}catch (NumberFormatException e){
			throw new FormattingException("Work hours incorrect format");
		}
	}


	public double getExpectedWorkHours() {
		return this.totalExpectedHours;
	}


	public void setActivityComplete() {
		this.complete = true;
	}


	public boolean isActivityComplete() {
		return this.complete;
	}


	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}
	
	public boolean matches(ActivityID activityID){
		return this.activityID.getName().equalsIgnoreCase(activityID.getName());
	}
	
	
}
