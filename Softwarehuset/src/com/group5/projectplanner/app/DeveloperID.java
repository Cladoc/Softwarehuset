package com.group5.projectplanner.app;

public class DeveloperID {
	private String name = "";
	public void DeveloperID(){}
	
	public void DeveloperID(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof DeveloperID){
			DeveloperID idToTest = (DeveloperID) obj;
			return this.name.equals(idToTest.getName());
		}else{
			return false;
		}
	}
}
