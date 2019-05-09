package com.group5.projectplanner.app;

import java.util.Scanner;

public class ProjectPlannerController {
	private ProjectPlanner projectPlanner;
	private ProjectPlannerView projectPlannerView;
	private Scanner console;
	//private DeveloperID signInDeveloper;
	private Developer signInDeveloper;
	
	// Anders (s163952)
	public void ProjectPlannerController(ProjectPlanner projectPlanner, 
			ProjectPlannerView projectPlannerView, Scanner console) {
		this.projectPlanner = projectPlanner;
		this.projectPlannerView = projectPlannerView;
		this.console = console;
	}
	
	// Anders (s163952)
	public void startMenu() {
		int choice = console.nextInt();
		while (choice < 1 || choice > 2) {
			projectPlannerView.startMenuFail();
			choice = console.nextInt();
		}
		if (choice == 1) { //developer sign-in
			System.out.println("Type 4 capital initials for your developer ID");
			String id = console.next();
			//*
			Developer developer = new Developer();
			developer.setID(id); 
			//*/
			if(projectPlanner.checkDeveloperExist(developer)) {
				projectPlannerView.mainMenu();
				//signInDeveloper = projectPlanner.getDeveloper(developer);
				signInDeveloper = developer;
				mainMenu();
			}
			else {
				projectPlannerView.fail("Your ID is not registered");
				startMenu();
			}
			
		}
		else if (choice == 2) { //add developer
			System.out.println("Type 4 capital initials for the developer you want to add");
			String id = console.next();
			//*
			Developer developer = new Developer();
			developer.setID(id);
			//*/
			try { 
				projectPlanner.addDeveloper(developer); 
			} catch (OperationNotAllowedException e) {
				projectPlannerView.fail(e.getMessage()); //write the fail message for addDeveloper
			}
			if (!projectPlanner.checkDeveloperExist(developer)) {
				signInDeveloper = developer;
				mainMenu();
			}
			else {
				System.out.println("Developer " + id + " does exist already");
				startMenu();
			}
				
		}
	}
	
	// Anders (s163952)
	public void mainMenu() {
		projectPlannerView.mainMenu();
		int choice = console.nextInt();
		while (choice < 1 || choice > 3) {
			System.out.println("You haven't typed 1, 2 or 3");
			choice = console.nextInt();
		}
		if (choice == 1) {
			makeProject();
		}
		else if (choice == 2) {
			editProject();
		}
		else registerHours();
	}
	
	// Anders (s163952)
	public void makeProject() {
		/*try { 
			projectPlanner.addProject(Project project, Developer signInDeveloper); 
		} catch (OperationNotAllowedException e) {
			projectPlannerView.fail(e.getMessage()); //write the fail message for addDeveloper
		}
		*/
				
	}
	
	
	// Anders (s163952)
	public void editProject() {
			
	}
	
	// Anders (s163952)
	public void registerHours() {
		
		
	}
	
}
