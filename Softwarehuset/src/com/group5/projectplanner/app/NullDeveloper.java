package com.group5.projectplanner.app;

public class NullDeveloper extends abstractDeveloper {
	
	@Override
	public void setName(String name) {}
	@Override
	public String getName() {
		return "Null Activity";
	}
	
	@Override
	public void registerHours(String week, String year, String hours, Activity activity) throws FormattingException ,NullObjectException {
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
