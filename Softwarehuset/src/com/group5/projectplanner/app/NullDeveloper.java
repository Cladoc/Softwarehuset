package com.group5.projectplanner.app;

public class NullDeveloper extends AbstractDeveloper {

	@Override
	public void setName(String name) {}
	
	@Override
	public void setID(DeveloperID developerID) {}
	
	@Override
	public String getName() {
		return "Null Activity";
	}
	
	@Override
	public void registerHours(String week, String year, String hours, AbstractActivity activity) 
			throws NullObjectException {
		throw new NullObjectException("Developer does not exist");
	}
	
	@Override
	public double getHours(int week, int year) throws NullObjectException {
		throw new NullObjectException("Developer does not exist");
	}
	
	@Override
	public boolean matches(DeveloperID developerID) throws NullObjectException{
		throw new NullObjectException("Developer does not exist");
	}
	@Override
	public boolean isNil() {
		return true;
	}
}
