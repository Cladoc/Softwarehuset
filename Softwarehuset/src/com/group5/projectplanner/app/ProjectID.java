package com.group5.projectplanner.app;

public class ProjectID {
	int serialNumber;
	int year;
	String name = "";
	
	public ProjectID(){}
	
	public ProjectID(String name){
		this.name = name;
	}
	
	public ProjectID(int year, int serialNumber, String name){
		setYear(year);
		setSerialNumber(serialNumber);
		setName(name);
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
