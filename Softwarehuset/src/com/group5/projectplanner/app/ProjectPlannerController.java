package com.group5.projectplanner.app;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProjectPlannerController {
	private ProjectPlanner projectPlanner;
	private ProjectPlannerView projectPlannerView;
	private Scanner console;
	private DeveloperID signedInDeveloperID;
	private ProjectID selectedProjectID;
	private ActivityID selectedActivityID;

	// Anders (s163952)
	public ProjectPlannerController(ProjectPlanner projectPlanner, ProjectPlannerView projectPlannerView,
			Scanner console) {
		this.projectPlanner = projectPlanner;
		this.projectPlannerView = projectPlannerView;
		this.console = console;
	}

	// Anders (s163952)
	// Main loop
	public void startMenu() throws OperationNotAllowedException, Exception, NullObjectException, FormattingException {
		int choice = -1;
		projectPlannerView.welcomeMessage();
		while (true) {
			projectPlannerView.startMenuMessage();
			choice = readInt();
			while (choice < 1 || choice > 3) {
				projectPlannerView.failMessage("You haven't typed 1, 2 or 3");
				choice = readInt();
			}
			if (choice == 1) { // developer sign-in
				System.out.println("Type 4 capital initials for your developer ID");
				String id = readDevID();
				if (!id.equals("")) {
					DeveloperID developerID = new DeveloperID();
					developerID.setName(id);
					if (projectPlanner.checkDeveloperExist(developerID)) {
						signedInDeveloperID = developerID;
						projectPlannerView.successMessage();
						mainMenu();
					} else {
						projectPlannerView.failMessage("Your ID is not registered");
					}
				} else {
					projectPlannerView.failMessage("ID must consist of 4 letters");
				}

			} else if (choice == 2) { // add developer
				System.out.println("Type 4 capital initials for the developer you want to add");
				String id = readDevID();
				if (!id.equals("")) {
					Developer developer = new Developer();
					developer.setName(id);
					try {
						projectPlanner.addDeveloper(developer);
						projectPlannerView.successMessage();
					} catch (OperationNotAllowedException e) {
						projectPlannerView.failMessage(e.getMessage()); // write
																		// the
																		// fail
																		// message
																		// for
																		// addDeveloper
					}
				} else {
					projectPlannerView.failMessage("ID must consist of 4 letters");
				}
			} else if (choice == 3) {
				// Stop program
				System.out.println("Bye bye!");
				break;
			}
		}
	}

	// Anders (s163952)
	public void mainMenu() throws OperationNotAllowedException, Exception, NullObjectException, FormattingException {
		while (true) {
			projectPlannerView.mainMenu();
			int choice = readInt();
			while (choice < 1 || choice > 4) {
				System.out.println("You haven't typed 1, 2, 3 or 4");
				choice = readInt();
			}
			if (choice == 1) {
				System.out.println("Enter a name");
				String name = console.nextLine();
				Project project = new Project();
				ProjectID projectID = new ProjectID(name);
				projectID.setName(name);
				project.setID(projectID);
				System.out.println("Enter a start year");
				String startYear = console.nextLine();
				try {
					project.setStartYear(startYear);
					try {
						projectPlanner.addProject(project, signedInDeveloperID);
						projectPlannerView.successMessage();
					} catch (OperationNotAllowedException e) {
						projectPlannerView.failMessage(e.getMessage());
					}
				} catch (FormattingException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 2) {
				selectAProject();
			} else if (choice == 3) {
				System.out.print("Yet to be implemented\n\n");
			} else if (choice == 4) {
				signedInDeveloperID = null;
				return;
			}
		}
	}

	public void selectAProject()
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		List<ProjectID> projectIDList = projectPlanner.getProjectIDs();
		if (projectIDList.size() <= 0) {
			projectPlannerView.failMessage("There are no projects!");
		} else {
			projectPlannerView.printProjectIDs(projectIDList);
			int choice = readInt();
			while (choice < 1 || choice > projectIDList.size()) {
				projectPlannerView.failMessage("The choice is not one of the listed projects!");
				choice = readInt();
			}
			selectedProjectID = projectIDList.get(choice - 1);
			projectPlannerView.successMessage();
			editProjectMenu();
		}
	}

	public void editProjectMenu()
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		while (true) {
			projectPlannerView.editProjectMenuMessage();
			int choice = readInt();
			while (choice < 1 || choice > 11) {
				projectPlannerView.failMessage("You haven't typed a number between 1 and 10");
				choice = readInt();
			}
			if (choice == 1) {
				System.out.println("Enter the developer ID you wish to set as leader");
				DeveloperID leaderID = new DeveloperID();
				leaderID.setName(readDevID());
				try {
					projectPlanner.setProjectLeader(selectedProjectID, leaderID);
					projectPlannerView.successMessage();
				} catch (OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 2) {
				System.out.println("Enter the name you wish to give the project");
				String name = console.nextLine();
				try {
					projectPlanner.editProjectName(selectedProjectID, signedInDeveloperID, name);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 3) {
				System.out.println("Enter the start year you wish to give the project");
				String startYear = console.nextLine();
				try {
					projectPlanner.setStartYear(selectedProjectID, startYear, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 4) {
				System.out.println("Enter the start week you wish to give the project");
				String startWeek = console.nextLine();
				try {
					projectPlanner.setStartWeek(selectedProjectID, startWeek, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 5) {
				System.out.println("Enter the end year you wish to give the project");
				String endYear = console.nextLine();
				try {
					projectPlanner.setEndYear(selectedProjectID, endYear, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 6) {
				System.out.println("Enter the end week you wish to give the project");
				String endWeek = console.nextLine();
				try {
					projectPlanner.setEndWeek(selectedProjectID, endWeek, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 7) {
				System.out.println("Enter the name of the new activity");
				String name = console.nextLine();
				Activity activity = new Activity();
				ActivityID activityID = new ActivityID();
				activityID.setName(name);
				activity.setID(activityID);
				try{
					projectPlanner.addProjectActivity(activity, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				}catch(OperationNotAllowedException e){
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 8) {
				ProjectData projData = projectPlanner.getProjectInformation(selectedProjectID, signedInDeveloperID);
				ProjectPlannerView.printProjectData(projData);
			} else if (choice == 9) {
				try {
				List<Activity> activityList = projectPlanner.getIncompleteActivities(selectedProjectID, signedInDeveloperID);
				projectPlannerView.printIncompleteActivityList(activityList);
				} catch (OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
			} else if (choice == 10) {
				selectAnActivity();
			} else if (choice == 11) {
				return;
			}
		}
	}
	
	public void selectAnActivity() throws NullObjectException, FormattingException, OperationNotAllowedException{
		List<ActivityID> activityIDList = projectPlanner.getActivityIDs(selectedProjectID, signedInDeveloperID);
		if (activityIDList.size() <= 0) {
			projectPlannerView.failMessage("There are no activities!");
		} else {
			projectPlannerView.printActivityIDs(activityIDList);
			int choice = readInt();
			while (choice < 1 || choice > activityIDList.size()) {
				projectPlannerView.failMessage("The choice is not one of the listed projects!");
				choice = readInt();
			}
			selectedActivityID = activityIDList.get(choice - 1);
			projectPlannerView.successMessage();
			editActivityMenu();
		}
	}
	
	public void editActivityMenu() throws NullObjectException, FormattingException, OperationNotAllowedException{
		while (true) {
			projectPlannerView.editActivityMenuMessage();
			int choice = readInt();
			while (choice < 1 || choice > 11) {
				projectPlannerView.failMessage("You haven't typed a number between 1 and 10");
				choice = readInt();
			}
			
			//delete
			System.out.println("1.  Assign developer");
			System.out.println("2.  Edit activity name");
			System.out.println("3.  Edit activity start year");
			System.out.println("4.  Edit activity start week");
			System.out.println("5.  Edit activity end year");
			System.out.println("6.  Edit activity end week");
			System.out.println("6.  Set expected work hours");
			System.out.println("7.  Mark activity as completed");
			System.out.println("8. Remove developer");
			System.out.println("9. Show activity information");
			System.out.println("10. Back");
			if (choice == 1) {
				System.out.println("enter a name");
				String name = console.nextLine();
				projectPlanner.setActivityName(selectedActivityID, selectedProjectID, name, signedInDeveloperID);
			} else if (choice == 2) {
				System.out.println("Enter the start year");
				String startYear = console.nextLine();
				try {
					projectPlanner.setActivityStartYear(startYear, selectedActivityID, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 3) {
				System.out.println("Enter the start week");
				String startWeek = console.nextLine();
				try {
					projectPlanner.setActivityStartWeek(startWeek, selectedActivityID, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 4) {
				System.out.println("Enter the end year");
				String endYear = console.nextLine();
				try {
					projectPlanner.setActivityEndYear(endYear, selectedActivityID, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 5) {
				System.out.println("Enter the end week");
				String endWeek = console.nextLine();
				try {
					projectPlanner.setActivityEndWeek(endWeek, selectedActivityID, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 6) {
				System.out.println("Enter the Expected work hours");
				String hours = console.nextLine();
				try {
					projectPlanner.setExpectedHours(selectedActivityID, selectedProjectID, signedInDeveloperID, hours);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 7) {
				try {
					projectPlanner.setActivityComplete(selectedActivityID, selectedProjectID, signedInDeveloperID);
					projectPlannerView.successMessage();
				} catch (OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}
				
			} else if (choice == 8) {
				System.out.println("Yet to be implemented");
				/*
				System.out.println("Enter the Expected work hours");
				String assignedDeveloper = readDevID();
				try {
					projectPlanner.assignDeveloper(selectedActivityID, selectedProjectID, signedInDeveloperID, assignedDeveloper);
					projectPlannerView.successMessage();
				} catch (FormattingException | OperationNotAllowedException e) {
					projectPlannerView.failMessage(e.getMessage());
				}*/
			} else if (choice == 9) {
				System.out.println("Yet to be implemented");
				//System.out.println("Enter name of developer you want to remove ");
				
			} else if (choice == 10) {
				System.out.println("Show Activity Information has yet to be implemented");
				
			} else if (choice == 11) {
				return;
			}
			
			
			
			}
	}

	public int readInt() {
		String input = console.nextLine();
		try {
			int choice = Integer.valueOf(input);
			return choice;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public String readDevID() {
		String input = console.nextLine();
		if (Pattern.matches("[a-zA-Z]{4}", input)) {
			return input;
		} else {
			return "";
		}
	}

}
