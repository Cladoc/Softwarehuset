package com.group5.projectplanner.app;

//Author: Casper (s163950)
public class NullProject extends AbstractProject{
	
	@Override
	public void setID(int id) {}
	
	@Override
	public int getID() {
		return 0;
	}
	
	@Override
	public void setName(String name){}
	
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
	public String getProjectInformation(Developer devLeader) throws NullObjectException{
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
	public boolean checkActivityExist(ProjectActivity projectActivity) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
		
	}

	@Override
	public void assignDeveloper(ProjectActivity projectActivity, Developer devLeader, Developer assignedDeveloper)
			throws OperationNotAllowedException, NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean checkDeveloperAssigned(ProjectActivity projectActivity, Developer assignedDeveloper) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setExpectedHours(ProjectActivity projectActivity, Developer devLeader, String hours)
			throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public double getExpectedHours(ProjectActivity projectActivity) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public void setActivityComplete(ProjectActivity projectActivity, Developer devLeader)
			throws NullObjectException{
		throw new NullObjectException("Project does not exist");
	}

	@Override
	public boolean isActivityComplete(ProjectActivity projectActivity) throws NullObjectException {
		throw new NullObjectException("Project does not exist");
	}
	
}
