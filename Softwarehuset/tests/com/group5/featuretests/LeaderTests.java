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
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		devLeader = new Developer();
		devLeader.setID("abcd");
		project = new Project();
		project.setName("Test");
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
		projectPlanner.addProjectActivity(projectActivity, project, devLeader);
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
		projectPlanner.addProjectActivity(projectActivity, project, devLeader);
		assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string} again")
	public void theProjectLeaderAddsAnActivityWithTheNameAgain(String name)
			throws NullObjectException, OperationNotAllowedException {
		ProjectActivity projectActivity2 = new ProjectActivity();
		projectActivity2.setName(name);
		try {
			projectPlanner.addProjectActivity(projectActivity2, project, devLeader);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Author: Casper (s163950)
	@Given("that he is not project leader on the project")
	public void thatHeIsNotProjectLeaderOnTheProject() throws Exception, FormattingException, NullObjectException {
		project = projectHelper.getProject();
		devLeader = developerHelper.getDeveloper();
		assertFalse(projectPlanner.isProjectLeader(project, devLeader));
	}

	// Author: Casper (s163950)
	@When("the developer tries to add an activity with the name {string}")
	public void theDeveloperTriesToAddAnActivityWithTheName(String string)
			throws NullObjectException, OperationNotAllowedException {
		try {
			projectPlanner.addProjectActivity(projectActivity, project, devLeader);
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
		projectPlanner.addProjectActivity(projectActivity, project, devLeader);
		assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}
	
	@When("the project leader sets start date of week {string} and year {string}")
	public void theProjectLeaderSetsStartDateOfWeekAndYear(String week, String year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setStartYear(project, year, devLeader);
			projectPlanner.setStartWeek(project, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
		
		// project.setEndWeek(week);
	   
	}

	@Then("the project has start date week {int} and year {int}")
	public void theProjectHasStartDateWeekAndYear(Integer week, Integer year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getStartYear(project));
		assertTrue(week == projectPlanner.getStartWeek(project));
	}
	
	@Given("the project has end date of week {string} and year {string}")
	public void theProjectHasEndDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(project, year, devLeader);
			projectPlanner.setEndWeek(project, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets an invalid start date of week {string} and year {string}")
	public void theProjectLeaderSetsAnInvalidStartDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setStartYear(project, year, devLeader);
			projectPlanner.setStartWeek(project, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}	    
	}

	@Then("he gets the invalid date error message {string}")
	public void heGetsTheInvalidDateErrorMessage(String error) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}
	
	@When("the Project leader sets end date of week {string} and year {string}")
	public void theProjectLeaderSetsEndDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(project, year, devLeader);
			projectPlanner.setEndWeek(project, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	

	@Then("the project has end date of week {int} and year {int}")
	public void theProjectHasEndDateOfWeekAndYear(Integer week, Integer year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getEndYear(project));
		assertTrue(week == projectPlanner.getEndWeek(project));
	}

	@Given("the project has start date of week {string} and year {string}")
	public void theProjectHasStartDateOfWeekAndYear(String week, String year) throws Exception, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.setStartYear(project, year, devLeader);
			projectPlanner.setStartWeek(project, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets invalid end date of week {string} and year {string}")
	public void theProjectLeaderSetsInvalidEndDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setEndYear(project, year, devLeader);
			projectPlanner.setEndWeek(project, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("he gets the invalid end date error message {string}")
	public void heGetsTheInvalidEndDateErrorMessage(String error) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessageHolder.getErrorMessage().equals(error));
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
	
	//Set expected work hours feature-----------------------------------------------------------
	@When("the project leader sets expected work hours to {string} in the activity")
	public void theProjectLeaderSetsExpectedWorkHoursToInTheActivity(String hours) throws OperationNotAllowedException, NullObjectException, NumberFormatException, FormattingException {
	    projectPlanner.setExpectedHours(projectActivity, project, devLeader, hours);
	}
	
	@Then("the activity has expected work hours set to {double}")
	public void theActivityHasExpectedWorkHoursSetTo(double hours) throws NullObjectException {
	    assertTrue(projectPlanner.getExpectedHours(projectActivity, project) == hours);
	}
	
	@When("the project leader sets expected work hours to {string}")
	public void theProjectLeaderSetsExpectedWorkHoursTo(String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
	    try{
	    	projectPlanner.setExpectedHours(projectActivity, project, devLeader, hours);
	    } catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	//Set activity complete feature------------------------------------------------
	
	@When("the project leader sets the activity as complete")
	public void theProjectLeaderSetsTheActivityAsComplete() throws OperationNotAllowedException, NullObjectException {
	    projectPlanner.setActivityComplete(projectActivity, project, devLeader);
	}

	@Then("the activity is registered as completed")
	public void theActivityIsRegisteredAsCompleted() throws NullObjectException {
		assertTrue(projectPlanner.isActivityComplete(projectActivity, project, devLeader));
	}


}
