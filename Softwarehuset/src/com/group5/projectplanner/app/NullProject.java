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
	public void setStartYear(String start) throws Exception, FormattingException {}
	
	@Override
	public int getStartYear() {
		return -1;
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
	public void setProjectLeader(Developer developer){}
	
	@Override
	public boolean isProjectLeader(Developer developer){
		return false;
	}
	
}
