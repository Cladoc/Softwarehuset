package com.group5.projectplanner.app;

//Author: Casper (s163950)
public class NullProject extends AbstractProject{
	
	@Override
	public void setID(ProjectID projectID) {}
	
	@Override
	public ProjectID getID() {
		return null;
	}
	
	@Override
	public void setName(String name, Developer devLeader){}
	
	@Override
	public String getName() { 
		return "Not available";
	}
	
	@Override
	public void setStartYear(String start) throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setStartWeek(String start, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setEndYear(String start, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setEndWeek(String start, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	
	@Override
	public int getStartYear() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public prjData getProjectInformation(Developer devLeader) throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getStartWeek() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getEndYear() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getEndWeek() throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public boolean isNil(){
		return true;
	}
	
	@Override
	public void setProjectLeader(Developer developer) throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public boolean isProjectLeader(Developer developer){
		return false;
	}
	
	@Override
	public void addProjectActivity(ProjectActivity projectActivity, Developer devLeader)
			throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean checkActivityExists(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
		
	}

	@Override
	public void assignDeveloper(ActivityID activityID, Developer devLeader, Developer assignedDeveloper)
			throws OperationNotAllowedException, NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean checkDeveloperAssigned(ActivityID activityID, Developer assignedDeveloper) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setExpectedHours(ActivityID activityID, Developer devLeader, String hours)
			throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public double getExpectedHours(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setActivityComplete(ActivityID activityID, Developer devLeader)
			throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setActivityStartWeek(String week ,ActivityID activityID, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setActivityStartYear(String week ,ActivityID activityID, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setActivityEndWeek(String week ,ActivityID activityID, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public void setActivityEndYear(String week ,ActivityID activityID, Developer devLeader) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean isActivityComplete(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getActivityStartWeek(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getActivityStartYear(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	
	@Override
	public int getActivityEndWeek(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
	@Override
	public int getActivityEndYear(ActivityID activityID) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	

	
}
