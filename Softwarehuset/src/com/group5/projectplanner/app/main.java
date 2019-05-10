package com.group5.projectplanner.app;

import java.util.Scanner;

public class main {
	public static void main(String[] args) throws OperationNotAllowedException, Exception, NullObjectException, FormattingException {
		ProjectPlanner projectPlanner = new ProjectPlanner();
		ProjectPlannerView projectPlannerView = new ProjectPlannerView();
		Scanner console = new Scanner(System.in);
		ProjectPlannerController projectPlannerController = new ProjectPlannerController(projectPlanner, projectPlannerView, console);
		projectPlannerController.startMenu();
	}
}
