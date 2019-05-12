package com.group5.projectplanner.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity extends AbstractActivity {
	private ActivityID activityID = new ActivityID();
	private DeveloperRepository developers = new DeveloperRepository();
	private double totalExpectedHours;
	private boolean complete;
	private int startWeek = 1;
	private int startYear = 0;
	private int endWeek = 52;
	private int endYear = 3000;
	
	public Activity() {
	}
	
	public Activity(ActivityID activityID) {
		this.activityID = activityID;
	}
	
	@Override
	public void setName(String name) throws FormattingException {
		String regex = "\\A[a-zA-Z].*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		boolean b = matcher.matches();
		if(b) {
			this.activityID.setName(name);
		}else {
			throw new FormattingException("An invalid activity name was entered");
		}
	}
	
	@Override
	public String getName() {
		return this.activityID.getName();
	}

	public void setID(ActivityID activityID) {
		this.activityID = activityID;
	}

	public ActivityID getID() {
		return this.activityID;
	}

	@Override
	public boolean isNil() {
		return false;
	}
	
	public void assignDeveloper(Developer devToAssign) throws OperationNotAllowedException {
		developers.addDeveloper(devToAssign);
		devToAssign.assignActivity(this);
	}
	
	public boolean checkDeveloperAssigned(DeveloperID assignedDeveloper) {
		return developers.checkDeveloperExists(assignedDeveloper);
	}
	
	public DeveloperRepository getDevelopers() {
		return this.developers;
	}
	
	public void setExpectedWorkHours(String hours) throws FormattingException {
		try {
			this.totalExpectedHours = Double.valueOf(hours);
		} catch (NumberFormatException e) {
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

	public boolean matches(ActivityID activityID) {
		return this.activityID.getName().equalsIgnoreCase(activityID.getName());
	}
	
	public void setActivityStartWeek(String week) throws FormattingException, NumberFormatException {
		int number = 0;
		try {
			number = Integer.valueOf(week);

		} catch (NumberFormatException e) {
			throw new FormattingException("Incorrect date format");
		}
		if (number <= 1 || number >= 53) {

			throw new FormattingException("Incorrect date format");
		}
		if (!((this.startYear == this.endYear && number <= this.endWeek) || this.startYear < this.endYear)) {
			throw new FormattingException("An invalid start date was entered");
		}
		this.startWeek = number;
		
	}

	public void setActivityStartYear(String year) throws FormattingException, NumberFormatException {
		int number = 0;
		try {
			number = Integer.valueOf(year);
		} catch (NumberFormatException e) {
			throw new FormattingException("Incorrect date format");
		}
		if (number < 1000 || number > 9999) {
			throw new FormattingException("Incorrect date format");
		}
		if (!((number == this.endYear && this.startWeek <= this.endWeek) || number < this.endYear)) {
			throw new FormattingException("An invalid start date was entered");
		}
		this.startYear = number;
	}

	public void setActivityEndWeek(String week) throws FormattingException, NumberFormatException {
		int number = 0;
		try {
			number = Integer.valueOf(week);

		} catch (NumberFormatException e) {
			throw new FormattingException("Incorrect date format");
		}

		if (number < 1 || number > 52) {
			throw new FormattingException("Incorrect date format");
		}
		if (((this.startYear == this.endYear && this.startWeek <= number) || this.startYear < this.endYear)) {
			this.endWeek = number;
		}else {
			throw new FormattingException("An invalid end date was entered");
		}

	}

	public void setActivityEndYear(String year) throws FormattingException, NumberFormatException {
		int number = 0;
		try {
			number = Integer.valueOf(year);
		} catch (NumberFormatException e) {
			throw new FormattingException("Incorrect date format");
		}
		if (number < 1000 || number > 9999) {
			throw new FormattingException("Incorrect date format");
		}
		if (((this.startYear == number && this.startWeek <= this.endWeek) || this.startYear < number)) {
			this.endYear = number;
		}else {
			throw new FormattingException("An invalid end date was entered");
		}
		
	}

	public int getActivityStartWeek() {
		return this.startWeek;
	}

	public int getActivityStartYear() {
		return this.startYear;
	}

	public int getActivityEndWeek() {
		return this.endWeek;
	}

	public int getActivityEndYear() {
		return this.endYear;
	}

	@Override
	public ActivityData getActivityInformation(DeveloperID developerID) {
		ActivityData activityData = new ActivityData();
		activityData.setID(this.activityID);
		activityData.setDevelopers(this.developers);
		activityData.setExpectedWorkHours(this.totalExpectedHours);
		activityData.setCompleteness(this.complete);
		activityData.setEndWeek(this.endWeek);
		activityData.setEndYear(this.endYear);
		activityData.setStartWeek(this.startWeek);
		activityData.setStartYear(this.startYear);
		
		return activityData;
	}
	
	public void unassignDeveloper(Developer dev) throws OperationNotAllowedException {
		developers.removeDeveloper(dev);		
	}

}
