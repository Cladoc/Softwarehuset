package com.group5.projectplanner.app;

public class Developer {
	private String developerID;

	public void setID(String string) {
		this.developerID = string;
	}

	public String getID() {
		return this.developerID;
	}
	
	//Author: Casper (s163950)
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Developer){
			Developer dev = (Developer) obj;
			return this.developerID.equalsIgnoreCase(dev.getID());
		}else{
			return false;
		}
	}
}
