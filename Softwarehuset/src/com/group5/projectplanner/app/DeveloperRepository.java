package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
	
	private List<Developer> developers = new ArrayList<>();
	
	//Author: Casper (s163950)
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExists(developer)){
			throw new OperationNotAllowedException("ID already exists");
		}else{
			developers.add(developer);
		}
	}
	
	//Author: Casper (s163950)
	public boolean checkDeveloperExists(Developer developer){
		//contains() uses object's equals() method
		return developers.contains(developer);
	}
	
	public void removeDeveloper(Developer developer) throws OperationNotAllowedException{
		if(!checkDeveloperExists(developer)){
			throw new OperationNotAllowedException("Developer does not exist");
		}else{
			developers.remove(developer);
		}
	}

}
