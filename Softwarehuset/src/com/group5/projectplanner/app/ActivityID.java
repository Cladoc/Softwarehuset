package com.group5.projectplanner.app;

public class ActivityID {
	private String name = "";
	
	public void ActivityID(){}
	public void ActivityID(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
