package com.group5.projectplanner.app;

import java.util.List;

public class ProjectPlannerView {
	
	public void welcomeMessage(){
		System.out.print("Welcome to the project planner\n\n");
	}
	
	// Anders (s163952)
	public void startMenuMessage() {
		System.out.println("Type 1 or 2 to select following options:");
		System.out.println("1. Developer sign-in");
		System.out.println("2. Add a developer");
		System.out.print("3. Exit project planner\n\n");
	}
	
	
	// Anders (s163952)
	public void failMessage(String failMessage) {
		System.out.print(failMessage+"\n\n");
	}
	
	// Anders (s163952)
	public void mainMenu() {
		System.out.println("Type 1, 2, 3 or 4 to select following options:");
		System.out.println("1. Make a new project");
		System.out.println("2. Edit a project");
		System.out.println("3. Register work hours");
		System.out.print("4. Sign out\n\n");
	}

	public void successMessage() {
		System.out.print("Success!\n\n");
	}


	public void printProjectIDs(List<ProjectID> projectNameList) {
		int k = 0;
		System.out.println("Choose a project ID:");
		for(ProjectID projectID : projectNameList){
			k++;
			System.out.println(k + ". Project name: " + "\"" + projectID.getName() + "\"");
		}
	}
	
	public void printActivityIDs(List<ActivityID> ActivityNameList) {
		int k = 0;
		System.out.println("Choose an activity ID:");
		for(ActivityID activityID : ActivityNameList){
			k++;
			System.out.println(k + ". Activity name: " + "\"" + activityID.getName() + "\"");
		}
	}

	public void editProjectMenuMessage() {
		System.out.println("1. Set project leader");
		System.out.println("2. Edit project name");
		System.out.println("3. Edit project start year");
		System.out.println("4. Edit project start week");
		System.out.println("5. Edit project end year");
		System.out.println("6. Edit project end week");
		System.out.println("7. Create activity");
		System.out.println("8. Show project information");
		System.out.println("9. Show incomlete activities");
		System.out.println("10. Edit activity");
		System.out.println("11. Back");
	}
}
