package com.group5.projectplanner.app;


public abstract class Activity {
	String name;
	double hours;
	int startDate;
	int endDate;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setHours(double hours){
		this.hours = hours;
	}
	
	public double getHours(){
		return this.hours;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Activity){
			Activity act = (Activity) obj;
			return this.name.equalsIgnoreCase(act.getName());
		}else{
			return false;
		}
	}
}
