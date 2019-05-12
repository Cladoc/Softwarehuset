package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
	
	private List<Developer> developers = new ArrayList<>();
	// Error messages
	private String incorrectInput = "Incorrect input";
	private String invalidWeek = "Invalid week entered";
	private String invalidYear = "Invalid year entered";
	
	public void addDeveloper(Developer developer) throws OperationNotAllowedException{
		if(checkDeveloperExists(developer.getDeveloperID())){
			throw new OperationNotAllowedException("Developer already exists");
		}else{
			developers.add(developer);
		}
	}
	
	public List<DeveloperID> getAvailableDevelopers(String week, String year) throws FormattingException {
		int weekInteger = 0;
		int yearInteger = 0;
		List<DeveloperID> developerIDs= new ArrayList<>();
		try {
			weekInteger = Integer.parseInt(week);
			yearInteger = Integer.parseInt(year);
			for(int i = 0; i < developers.size(); i++) {
				developers.get(i).getHours(weekInteger, yearInteger);			
				if(developers.get(i).getHours(weekInteger, yearInteger) < 40.0 ) {
					developerIDs.add(developers.get(i).getDeveloperID());
				}
			}
			
			
			if(weekInteger > 53 || weekInteger < 1) {		
				throw new FormattingException(invalidWeek);
			}
			else if(yearInteger >= 3000 || yearInteger < 2000)
			{
				throw new FormattingException(invalidYear);
			}
			
			return developerIDs;
		}catch (Exception e)
		{
			throw new FormattingException(incorrectInput);			
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
	
	public AbstractDeveloper getDeveloper(DeveloperID developerID){
		for(Developer listActivity : developers){
			if(listActivity.matches(developerID)){
				return listActivity;
			}
		}
		return new NullDeveloper();
	}

	public List<Developer> getDeveloperList(){
		return developers;
	}
}
