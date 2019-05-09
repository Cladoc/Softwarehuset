package com.group5.projectplanner.app;

public class ProjectPlannerView {
	
	// Anders (s163952)
	public void startMenu() {
		System.out.println("Type 1 or 2 to select following options:");
		System.out.println("1 Developer sign-in");
		System.out.println("2 Add a developer");		
	}
	
	// Anders (s163952)
	public static void startMenuFail() {
		System.out.println("You haven't typed 1 or 2");
	}
	
	// Anders (s163952)
	public void fail(String failMessage) {
		System.out.println(failMessage);
	}
	
	// Anders (s163952)
	public static void startMenuViewSucces() {
		
	}
	
	// Anders (s163952)
	public void mainMenu() {
		System.out.println("Type 1, 2 or 3 to select following options:");
		System.out.println("1 Make a new project");
		System.out.println("2 Edit a project");
		System.out.println("3 Register work hours");
	}
}
