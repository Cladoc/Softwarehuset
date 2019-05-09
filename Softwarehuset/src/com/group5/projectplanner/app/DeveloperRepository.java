package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
	
	private List<Developer> developers = new ArrayList<>();
	
	//Author: Casper (s163950)
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExists(developer.getDeveloperID())){
			throw new OperationNotAllowedException("ID already exists");
		}else{
			developers.add(developer);
		}
	}
	
	public boolean checkDeveloperExists(DeveloperID developerID) {
		for(Developer listDeveloper: developers){
			if(listDeveloper.getName().equalsIgnoreCase(developerID.getName())){
				return true;
			}
		}
		return false;
	}
	

	
	public void removeDeveloper(Developer developer) throws OperationNotAllowedException{
		if(!checkDeveloperExists(developer.getDeveloperID())){
			throw new OperationNotAllowedException("Developer does not exist");
		}else{
			developers.remove(developer);
		}
	}
	
	public abstractDeveloper getDeveloper(DeveloperID developerID){
		for(Developer listActivity : developers){
			if(listActivity.matches(developerID)){
				return listActivity;
			}
		}
		return new NullDeveloper();
	}

}
