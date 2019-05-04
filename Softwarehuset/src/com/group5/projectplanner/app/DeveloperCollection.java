package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

//Author: Casper (s163950)
public class DeveloperCollection {

	private List<Developer> developers = new ArrayList<>();
	
	//Author: Casper (s163950)
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		if(devAssigned(developer)){
			throw new OperationNotAllowedException("ID already exists");
		}else{
			developers.add(developer);
		}
	}
	
	//Author: Casper (s163950)
	public boolean devAssigned(Developer developer){
		//contains() uses object's equals() method
		return developers.contains(developer);
	}

	public void checkActivityAssigned(ProjectActivity projectActivity, Project project, Developer testDeveloper) {
		
	}
	
	
	
}
