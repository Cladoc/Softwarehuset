package com.group5.projectplanner.app;

public class NullActivity extends AbstractActivity {
	
	private String activNotExist = "Activity does not exist";
	
	@Override
	public void setName(String name) {}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Null Activity";
	}


	@Override
	public boolean isNil() {
		return true;
	}

	//Author: Casper (s163950)
	@Override
	public boolean equals(Object obj){
		return false;	
	}

	@Override
	public void assignDeveloper(Developer assignedDeveloper) throws NullObjectException {
		throw new NullObjectException(activNotExist);
		
	}

	@Override
	public boolean checkDeveloperAssigned(DeveloperID assignedDeveloperID) throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public void setExpectedWorkHours(String hours) throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public double getExpectedWorkHours() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public void setActivityComplete() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public boolean isActivityComplete() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public void setActivityStartWeek(String week) throws NullObjectException, FormattingException {
		throw new NullObjectException(activNotExist);
		
	}

	@Override
	public void setActivityStartYear(String year) throws NullObjectException, FormattingException {
		throw new NullObjectException(activNotExist);
		
	}
	
	@Override
	public void setActivityEndWeek(String week) throws NullObjectException, FormattingException {
		throw new NullObjectException(activNotExist);
		
	}

	@Override
	public void setActivityEndYear(String year) throws NullObjectException, FormattingException {
		throw new NullObjectException(activNotExist);
		
	}
	
	@Override
	public int getActivityStartWeek() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}
	
	@Override
	public int getActivityStartYear() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}
	
	@Override
	public int getActivityEndWeek() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}
	
	@Override
	public int getActivityEndYear() throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}

	@Override
	public ActivityData getActivityInformation(DeveloperID developerID) 
			throws NullObjectException {
		throw new NullObjectException(activNotExist);
	}
	
}
