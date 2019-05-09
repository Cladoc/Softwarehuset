package com.group5.projectplanner.app;

public class NullActivity extends Activity {
	
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
		throw new NullObjectException("Activity does not exist");
		
	}

	@Override
	public boolean checkDeveloperAssigned(DeveloperID assignedDeveloperID) throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}

	@Override
	public void setExpectedWorkHours(String hours) throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}

	@Override
	public double getExpectedWorkHours() throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}

	@Override
	public void setActivityComplete() throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}

	@Override
	public boolean isActivityComplete() throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}
	
}
