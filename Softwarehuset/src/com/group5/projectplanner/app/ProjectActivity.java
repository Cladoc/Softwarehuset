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
			developers.addDeveloper(assignedDeveloper);
		}else{
			throw new OperationNotAllowedException("Developer already assigned");
		}
	}


	public boolean checkDeveloperAssigned(Developer assignedDeveloper) {
		return developers.checkDeveloperExist(assignedDeveloper);
	}


	public void setExpectedWorkHours(String hours) throws FormattingException{
		try{
			this.totalExpectedHours = Double.valueOf(hours);
		}catch (NumberFormatException e){
			throw new FormattingException("Work hours incorrect format");
		}
	}


	public double getExpectedWorkHours() {
		return this.totalExpectedHours;
	}


	public void setActivityComplete() {
		this.complete = true;
	}


	public boolean isActivityComplete() {
		return this.complete;
	}
	
	
}
