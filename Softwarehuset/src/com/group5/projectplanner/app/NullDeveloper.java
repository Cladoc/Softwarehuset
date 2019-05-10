package com.group5.projectplanner.app;

public class NullDeveloper extends AbstractDeveloper {
	
	@Override
	public void setName(String name) {}
	@Override
	public String getName() {
		return "Null Activity";
	}
	
	@Override
	public void registerHours(int week, int year, double hours, AbstractActivity activity) throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}
	
	@Override
	public double getHours(int week, int year) throws NullObjectException {
		throw new NullObjectException("Activity does not exist");
	}
	
	@Override
	//Author: Casper (s163950)
	public boolean matches(DeveloperID developerID) throws NullObjectException{
		throw new NullObjectException("Activity does not exist");
	}
	@Override
	public boolean isNil() {
		return true;
	}
}
