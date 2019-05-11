package com.group5.projectplanner.app;

public class ProjectID {
	int serialNumber = -1;
	int year = -1;
	String name = "";
	
	public ProjectID(){}
	
	public ProjectID(String name){
		this.name = name;
	}
	
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public void setSerialNumber(int serialNumber){
		this.serialNumber = serialNumber;
	}
	
	public int getSerialNumber(){
		return this.serialNumber;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
}
