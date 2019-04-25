package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends Activity {
	
	private String name = "";
	//private List<Developer> developers = new ArrayList<>();
	private DeveloperCollection developers = new DeveloperCollection();
	private double totalExpectedHours;
	private boolean complete;
	
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Activity){
			Activity act = (Activity) obj;
			return this.name.equalsIgnoreCase(act.getName());
		}else{
			return false;
		}
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public boolean isNil() {
		return false;
	}


	public void assignDeveloper(Developer assignedDeveloper) throws OperationNotAllowedException {
		if(!developers.checkDeveloperExist(assignedDeveloper))
		{
			System.out.println(assignedDeveloper.getID());
			developers.addDeveloper(assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer already assigned");
		}
	}


	public boolean checkDeveloperAssigned(Developer assignedDeveloper) {
		return developers.checkDeveloperExist(assignedDeveloper);
	}
	
	
}
