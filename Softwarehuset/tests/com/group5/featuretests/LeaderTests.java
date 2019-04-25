package com.group5.featuretests;

import com.group5.projectplanner.app.ProjectPlanner;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;
import com.group5.projectplanner.app.ProjectActivity;
import com.group5.projectplanner.app.OperationNotAllowedException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LeaderTests {
	ProjectPlanner projectPlanner;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	DeveloperHelper developerHelper;
	Developer devLeader;
	Developer testDeveloper;
	Project project;
	ProjectActivity projectActivity;

	public LeaderTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder,
			ProjectHelper projectHelper, DeveloperHelper developerHelper) {
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.projectHelper = projectHelper;
		this.developerHelper = developerHelper;
	}

	// Author: Casper (s163950)
	@Given("a developer is project leader on a project registered in the project planner")
	public void aDeveloperIsProjectLeaderOnAProjectRegisteredInTheProjectPlanner()
			throws Exception, FormattingException, OperationNotAllowedException {
		devLeader = new Developer();
		devLeader.setID("abcd");
		project = new Project();
		project.setName("test");
		project.setStartYear("2020");
		projectPlanner.addDeveloper(devLeader);
		projectPlanner.addProject(project, devLeader);
		projectPlanner.setProjectLeader(project, devLeader);
		assertTrue(projectPlanner.isProjectLeader(project, devLeader));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string}")
	public void theProjectLeaderAddsAnActivityWithTheName(String name)
			throws NullObjectException, OperationNotAllowedException {
		projectActivity = new ProjectActivity();
		projectActivity.setName(name);
		assertTrue(projectActivity.getName().equals(name));
		projectPlanner.addActivity(projectActivity, project, devLeader);
	}

	// Author: Casper (s163950)
	@Then("the activity with name {string} is added to the project")
	public void theActivityWithNameIsAddedToTheProject(String string) throws NullObjectException {
		assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}

	// Author: Casper (s163950)
	@Given("an activity is registered with the name {string}")
	public void anActivityIsRegisteredWithTheName(String name)
			throws NullObjectException, OperationNotAllowedException {
		projectActivity = new ProjectActivity();
		projectActivity.setName(name);
		projectPlanner.addActivity(projectActivity, project, devLeader);
		assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string} again")
	public void theProjectLeaderAddsAnActivityWithTheNameAgain(String name)
			throws NullObjectException, OperationNotAllowedException {
		ProjectActivity projectActivity2 = new ProjectActivity();
		projectActivity2.setName(name);
		try {
			projectPlanner.addActivity(projectActivity2, project, devLeader);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Author: Casper (s163950)
	@Given("that he is not project leader on the project")
	public void thatHeIsNotProjectLeaderOnTheProject() throws Exception, FormattingException {
		project = projectHelper.getProject();
		devLeader = developerHelper.getDeveloper();
		assertFalse(projectPlanner.isProjectLeader(project, devLeader));
	}

	// Author: Casper (s163950)
	@When("the developer tries to add an activity with the name {string}")
	public void theDeveloperTriesToAddAnActivityWithTheName(String string)
			throws NullObjectException, OperationNotAllowedException {
		try {
			projectPlanner.addActivity(projectActivity, project, devLeader);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// -------Assign developer
	// Author: Casper (s163950)
	@Given("an activity with the name {string} is added to the project")
	public void anActivityWithTheNameIsAddedToTheProject(String activityName)
			throws NullObjectException, OperationNotAllowedException {
		projectActivity = new ProjectActivity();
		projectActivity.setName(activityName);
		projectPlanner.addActivity(projectActivity, project, devLeader);
		assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}
	
	@When("the project leader assigns a developer to the activity")
	public void theProjectLeaderAssignsADeveloperToTheActivity() throws NullObjectException, OperationNotAllowedException {
	    testDeveloper = new Developer();
	    testDeveloper.setID("test");
	    projectPlanner.addDeveloper(testDeveloper);
	    projectPlanner.assignDeveloper(projectActivity, project, devLeader, testDeveloper);
	}
	
	@Then("the developer is assigned to the activity")
	public void theDeveloperIsAssignedToTheActivity() throws OperationNotAllowedException, NullObjectException {
	    assertTrue(projectPlanner.checkDeveloperAssigned(projectActivity, project, testDeveloper));
	}
	
	@When("the project leader assigns a developer to an activity under the project where he is already assigned")
	public void theProjectLeaderAssignsADeveloperToAnActivityUnderTheProjectWhereHeIsAlreadyAssigned() throws NullObjectException, OperationNotAllowedException {
	    testDeveloper = new Developer();
	    testDeveloper.setID("test");
		projectPlanner.addDeveloper(testDeveloper);
		projectPlanner.assignDeveloper(projectActivity, project, devLeader, testDeveloper);
	    try{
	    	projectPlanner.assignDeveloper(projectActivity, project, devLeader, testDeveloper);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }  
	}

}
