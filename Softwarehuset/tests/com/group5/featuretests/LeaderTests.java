package com.group5.featuretests;

import com.group5.projectplanner.app.ProjectPlanner;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;
import com.group5.projectplanner.app.ProjectID;
import com.group5.projectplanner.app.ProjectActivity;
import com.group5.projectplanner.app.ActivityID;
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
	ProjectID projectID;
	ProjectActivity projectActivity;
	ActivityID activityID;
	String projectInformation;

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
		projectID = new ProjectID("Test");
		project = new Project();
		project.setID(projectID);
		project.setStartYear("2020");
		projectPlanner.addDeveloper(devLeader);
		projectPlanner.addProject(project, devLeader);
		projectPlanner.setProjectLeader(projectID, devLeader);
		assertTrue(projectPlanner.isProjectLeader(projectID, devLeader));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string}")
	public void theProjectLeaderAddsAnActivityWithTheName(String name)
			throws NullObjectException, OperationNotAllowedException {
		activityID = new ActivityID();
		activityID.setName(name);
		projectActivity = new ProjectActivity(activityID);
		assertTrue(projectActivity.getName().equals(name));
		projectPlanner.addProjectActivity(projectActivity, projectID, devLeader);
	}

	// Author: Casper (s163950)
	@Then("the activity with name {string} is added to the project")
	public void theActivityWithNameIsAddedToTheProject(String string) throws NullObjectException {
		assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}

	// Author: Casper (s163950)
	@Given("an activity with the name {string} is added to the project")
	public void anActivityWithTheNameIsAddedToTheProject(String name)
			throws NullObjectException, OperationNotAllowedException {
		activityID = new ActivityID();
		activityID.setName(name);
		projectActivity = new ProjectActivity(activityID);
		projectPlanner.addProjectActivity(projectActivity, projectID, devLeader);
		assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string} again")
	public void theProjectLeaderAddsAnActivityWithTheNameAgain(String name)
			throws NullObjectException, OperationNotAllowedException {
		ProjectActivity projectActivity2 = new ProjectActivity();
		projectActivity2.setName(name);
		try {
			projectPlanner.addProjectActivity(projectActivity2, projectID, devLeader);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Author: Casper (s163950)
	@Given("that he is not project leader on the project")
	public void thatHeIsNotProjectLeaderOnTheProject() throws Exception, FormattingException, NullObjectException {
		project = projectHelper.getProject();
		projectID = project.getID();
		devLeader = developerHelper.getDeveloper();
		assertFalse(projectPlanner.isProjectLeader(projectID, devLeader));
	}

	// Author: Casper (s163950)
	@When("the developer tries to add an activity with the name {string}")
	public void theDeveloperTriesToAddAnActivityWithTheName(String string)
			throws NullObjectException, OperationNotAllowedException {
		try {
			projectPlanner.addProjectActivity(projectActivity, projectID, devLeader);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// -------Assign developer feature--------------
	
	@When("the project leader assigns a developer to the activity")
	public void theProjectLeaderAssignsADeveloperToTheActivity() throws NullObjectException, OperationNotAllowedException {
	    testDeveloper = new Developer();
	    testDeveloper.setID("test");
	    projectPlanner.addDeveloper(testDeveloper);
	    projectPlanner.assignDeveloper(activityID, projectID, devLeader, testDeveloper);
	}
	
	@Then("the developer is assigned to the activity")
	public void theDeveloperIsAssignedToTheActivity() throws OperationNotAllowedException, NullObjectException {
	    assertTrue(projectPlanner.checkDeveloperAssigned(activityID, projectID, testDeveloper));
	}
	
	@When("the project leader assigns a developer to an activity under the project where he is already assigned")
	public void theProjectLeaderAssignsADeveloperToAnActivityUnderTheProjectWhereHeIsAlreadyAssigned() throws NullObjectException, OperationNotAllowedException {
	    testDeveloper = new Developer();
	    testDeveloper.setID("test");
		projectPlanner.addDeveloper(testDeveloper);
		projectPlanner.assignDeveloper(activityID, projectID, devLeader, testDeveloper);
	    try{
	    	projectPlanner.assignDeveloper(activityID, projectID, devLeader, testDeveloper);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }  
	}
	
	//Edit date features
	
	@When("the project leader sets start date of week {string} and year {string}")
	public void theProjectLeaderSetsStartDateOfWeekAndYear(String week, String year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setStartYear(projectID, year, devLeader);
			projectPlanner.setStartWeek(projectID, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}   
	}

	@Then("the project has start date week {int} and year {int}")
	public void theProjectHasStartDateWeekAndYear(Integer week, Integer year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getStartYear(projectID));
		assertTrue(week == projectPlanner.getStartWeek(projectID));
	}
	
	@Given("the project has end date of week {string} and year {string}")
	public void theProjectHasEndDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(projectID, year, devLeader);
			projectPlanner.setEndWeek(projectID, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets an invalid start date of week {string} and year {string}")
	public void theProjectLeaderSetsAnInvalidStartDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setStartYear(projectID, year, devLeader);
			projectPlanner.setStartWeek(projectID, week, devLeader);
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
			projectPlanner.setEndYear(projectID, year, devLeader);
			projectPlanner.setEndWeek(projectID, week, devLeader);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	

	@Then("the project has end date of week {int} and year {int}")
	public void theProjectHasEndDateOfWeekAndYear(Integer week, Integer year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getEndYear(projectID));
		assertTrue(week == projectPlanner.getEndWeek(projectID));
	}

	@Given("the project has start date of week {string} and year {string}")
	public void theProjectHasStartDateOfWeekAndYear(String week, String year) throws Exception, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.setStartYear(projectID, year, devLeader);
			projectPlanner.setStartWeek(projectID, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets invalid end date of week {string} and year {string}")
	public void theProjectLeaderSetsInvalidEndDateOfWeekAndYear(String week, String year) throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setEndYear(projectID, year, devLeader);
			projectPlanner.setEndWeek(projectID, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("he gets the invalid end date error message {string}")
	public void heGetsTheInvalidEndDateErrorMessage(String error) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}
	
	
	
	//Set expected work hours feature-----------------------------------------------------------
	@When("the project leader sets expected work hours to {string} in the activity")
	public void theProjectLeaderSetsExpectedWorkHoursToInTheActivity(String hours) throws OperationNotAllowedException, NullObjectException, NumberFormatException, FormattingException {
	    projectPlanner.setExpectedHours(activityID, projectID, devLeader, hours);
	}
	
	@Then("the activity has expected work hours set to {double}")
	public void theActivityHasExpectedWorkHoursSetTo(double hours) throws NullObjectException {
	    assertTrue(projectPlanner.getExpectedHours(activityID, projectID) == hours);
	}
	
	@When("the project leader sets expected work hours to {string}")
	public void theProjectLeaderSetsExpectedWorkHoursTo(String hours) throws OperationNotAllowedException, NullObjectException, FormattingException {
	    try{
	    	projectPlanner.setExpectedHours(activityID, projectID, devLeader, hours);
	    } catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	//Set activity complete feature------------------------------------------------
	
	@When("the project leader sets the activity as complete")
	public void theProjectLeaderSetsTheActivityAsComplete() throws OperationNotAllowedException, NullObjectException {
	    projectPlanner.setActivityComplete(activityID, projectID, devLeader);
	}

	@Then("the activity is registered as completed")
	public void theActivityIsRegisteredAsCompleted() throws NullObjectException {
		assertTrue(projectPlanner.isActivityComplete(activityID, projectID, devLeader));
	}
	
	@When("the project leader sets start date as letters of week {string} and year {string}")
	public void theProjectLeaderSetsStartDateAsLettersOfWeekAndYear(String week, String year) throws Exception, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setStartYear(projectID, year, devLeader);
			projectPlanner.setStartWeek(projectID, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets end date as letters of week {string} and year {string}")
	public void theProjectLeaderSetsEndDateAsLettersOfWeekAndYear(String week, String year) throws Exception, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(projectID, year, devLeader);
			projectPlanner.setEndWeek(projectID, week, devLeader);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets projectName to {string}")
	public void theProjectLeaderSetsProjectNameTo(String name) throws OperationNotAllowedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.editProjectName(projectID, devLeader, name);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project has the name {string}")
	public void theProjectHasTheName(String name) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(projectPlanner.getProjectName(projectID));
		assertTrue(projectPlanner.getProjectName(projectID).equals(name));
	   
	}

	@When("the project leader sets an invalid projectName of {string}")
	public void theProjectLeaderSetsAnInvalidProjectNameOf(String name) throws OperationNotAllowedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.editProjectName(projectID, devLeader, name);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	

	@Then("he gets the invalid name error message {string}")
	public void heGetsTheInvalidNameErrorMessage(String error) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}
	


}
