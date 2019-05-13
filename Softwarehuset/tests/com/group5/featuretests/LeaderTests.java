package com.group5.featuretests;

import com.group5.projectplanner.app.ProjectPlanner;
import com.group5.projectplanner.app.ProjectData;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.DeveloperID;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;
import com.group5.projectplanner.app.ProjectID;
import com.group5.projectplanner.app.Activity;
import com.group5.projectplanner.app.ActivityID;
import com.group5.projectplanner.app.OperationNotAllowedException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class LeaderTests {
	ProjectPlanner projectPlanner;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	DeveloperHelper developerHelper;
	Developer devLeader;
	Developer testDeveloper;
	ProjectData prjData;
	Project project;
	ProjectID projectID;
	Activity projectActivity;
	ActivityID activityID;
	DeveloperID devLeaderID;
	DeveloperID developerID;
	String projectInformation;
	List<Activity> incompleteActivities;
	List<DeveloperID> developerIDs= new ArrayList<>();

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
		devLeader.setName("abcd");
		projectID = new ProjectID("Test");
		project = new Project();
		project.setID(projectID);
		project.setStartYear("2020");
		devLeaderID = devLeader.getDeveloperID();
		projectPlanner.addDeveloper(devLeader);
		projectPlanner.addProject(project, devLeaderID);
		projectPlanner.setProjectLeader(projectID, devLeaderID);
		assertTrue(projectPlanner.isProjectLeader(projectID, devLeaderID));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string}")
	public void theProjectLeaderAddsAnActivityWithTheName(String name)
			throws NullObjectException, OperationNotAllowedException {
		activityID = new ActivityID();
		activityID.setName(name);
		projectActivity = new Activity(activityID);
		assertTrue(projectActivity.getName().equals(name));
		projectPlanner.addProjectActivity(projectActivity, projectID, devLeaderID);
	}

	// Author: Casper (s163950)
	@Then("the activity with name {string} is added to the project")
	public void theActivityWithNameIsAddedToTheProject(String name) throws NullObjectException {
		activityID = new ActivityID();
		activityID.setName(name);
		assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}

	// Author: Casper (s163950)
	@Given("an activity with the name {string} is added to the project")
	public void anActivityWithTheNameIsAddedToTheProject(String name)
			throws NullObjectException, OperationNotAllowedException, Exception, FormattingException {
		activityID = new ActivityID();
		activityID.setName(name);
		projectActivity = new Activity(activityID);
		devLeader = new Developer();
		devLeader.setName("abcd");
		projectID = new ProjectID("Test");
		project = new Project();
		project.setID(projectID);
		project.setStartYear("2020");
		devLeaderID = devLeader.getDeveloperID();
		
		projectPlanner.setProjectLeader(projectID, devLeaderID);
		projectPlanner.addProjectActivity(projectActivity, projectID, devLeader.getDeveloperID());
		assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}

	// Author: Casper (s163950)
	@When("the project leader adds an activity with the name {string} again")
	public void theProjectLeaderAddsAnActivityWithTheNameAgain(String name)
			throws NullObjectException, OperationNotAllowedException, FormattingException {
		Activity projectActivity2 = new Activity();
		projectActivity2.setName(name);
		try {
			projectPlanner.addProjectActivity(projectActivity2, projectID, devLeaderID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Author: Casper (s163950)
	@Given("that he is not project leader on the project")
	public void thatHeIsNotProjectLeaderOnTheProject() throws Exception, FormattingException, NullObjectException {
		project = projectHelper.getProject();
		projectID = project.getID();
		testDeveloper = developerHelper.getDeveloper();
		developerID = testDeveloper.getDeveloperID();
		assertFalse(projectPlanner.isProjectLeader(projectID, developerID));
	}

	// Author: Casper (s163950)
	@When("the developer tries to add an activity with the name {string}")
	public void theDeveloperTriesToAddAnActivityWithTheName(String name)
			throws NullObjectException, OperationNotAllowedException {
		try {
			projectActivity = new Activity();
			activityID = new ActivityID();
			activityID.setName(name);
			projectActivity.setID(activityID);
			projectPlanner.addProjectActivity(projectActivity, projectID, testDeveloper.getDeveloperID());
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// -------Assign developer feature--------------
	
	@When("the project leader assigns a developer to the activity")
	public void theProjectLeaderAssignsADeveloperToTheActivity() throws NullObjectException, OperationNotAllowedException {
	    testDeveloper = new Developer();
	    testDeveloper.setName("test");
	    developerID = testDeveloper.getDeveloperID();
	    projectPlanner.addDeveloper(testDeveloper);
	    projectPlanner.assignDeveloper(activityID, projectID, devLeaderID, developerID);
	}
	
	@Then("the developer is assigned to the activity")
	public void theDeveloperIsAssignedToTheActivity() throws OperationNotAllowedException, NullObjectException {
	    assertTrue(projectPlanner.checkDeveloperAssigned(activityID, projectID, testDeveloper.getDeveloperID()));
	}
	
	@When("the project leader assigns a developer to an activity under the project where he is already assigned")
	public void theProjectLeaderAssignsADeveloperToAnActivityUnderTheProjectWhereHeIsAlreadyAssigned()
			throws NullObjectException, OperationNotAllowedException {
		testDeveloper = new Developer();
		testDeveloper.setName("test");
		developerID = new DeveloperID();
	    developerID.setName("test");
		projectPlanner.addDeveloper(testDeveloper);
		projectPlanner.assignDeveloper(activityID, projectID, devLeaderID, developerID);
		try {
			projectPlanner.assignDeveloper(activityID, projectID, devLeaderID, developerID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Edit date features

	@When("the project leader sets start date of week {string} and year {string}")
	public void theProjectLeaderSetsStartDateOfWeekAndYear(String week, String year)
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setStartYear(projectID, year, devLeaderID);
			projectPlanner.setStartWeek(projectID, week, devLeaderID);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project has start date week {int} and year {int}")
	public void theProjectHasStartDateWeekAndYear(Integer week, Integer year)
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getStartYear(projectID));
		assertTrue(week == projectPlanner.getStartWeek(projectID));
	}

	@Given("the project has end date of week {string} and year {string}")
	public void theProjectHasEndDateOfWeekAndYear(String week, String year)
			throws FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(projectID, year, devLeaderID);
			projectPlanner.setEndWeek(projectID, week, devLeaderID);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets an invalid start date of week {string} and year {string}")
	public void theProjectLeaderSetsAnInvalidStartDateOfWeekAndYear(String week, String year)
			throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setStartYear(projectID, year, devLeaderID);
			projectPlanner.setStartWeek(projectID, week, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the Project leader sets end date of week {string} and year {string}")
	public void theProjectLeaderSetsEndDateOfWeekAndYear(String week, String year)
			throws FormattingException, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(projectID, year, devLeaderID);
			projectPlanner.setEndWeek(projectID, week, devLeaderID);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project has end date of week {int} and year {int}")
	public void theProjectHasEndDateOfWeekAndYear(Integer week, Integer year)
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(year == projectPlanner.getEndYear(projectID));
		assertTrue(week == projectPlanner.getEndWeek(projectID));
	}

	@Given("the project has start date of week {string} and year {string}")
	public void theProjectHasStartDateOfWeekAndYear(String week, String year)
			throws Exception, OperationNotAllowedException, NullObjectException {
		// Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.setStartYear(projectID, year, devLeaderID);
			projectPlanner.setStartWeek(projectID, week, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets invalid end date of week {string} and year {string}")
	public void theProjectLeaderSetsInvalidEndDateOfWeekAndYear(String week, String year)
			throws FormattingException, OperationNotAllowedException, NullObjectException, Exception {
		try {
			projectPlanner.setEndYear(projectID, year, devLeaderID);
			projectPlanner.setEndWeek(projectID, week, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("he gets the invalid end date error message {string}")
	public void heGetsTheInvalidEndDateErrorMessage(String error) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}

	// Set expected work hours
	// feature-----------------------------------------------------------

	@Then("the activity has expected work hours set to {double}")
	public void theActivityHasExpectedWorkHoursSetTo(double hours) throws NullObjectException {
		assertTrue(projectPlanner.getExpectedHours(activityID, projectID) == hours);
	}

	@When("the project leader sets expected work hours to {string}")
	public void theProjectLeaderSetsExpectedWorkHoursTo(String hours)
			throws OperationNotAllowedException, NullObjectException, FormattingException {
		try {
			projectPlanner.setExpectedHours(activityID, projectID, devLeaderID, hours);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	// Set activity complete feature------------------------------------------------

	@When("the project leader sets the activity as complete")
	public void theProjectLeaderSetsTheActivityAsComplete() throws OperationNotAllowedException, NullObjectException {
		projectPlanner.setActivityComplete(activityID, projectID, devLeaderID);
	}

	@Then("the activity is registered as completed")
	public void theActivityIsRegisteredAsCompleted() throws NullObjectException {
		assertTrue(projectPlanner.isActivityComplete(activityID, projectID, devLeader));
	}

	@When("the project leader sets start date as letters of week {string} and year {string}")
	public void theProjectLeaderSetsStartDateAsLettersOfWeekAndYear(String week, String year)
			throws Exception, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setStartYear(projectID, year, devLeaderID);
			projectPlanner.setStartWeek(projectID, week, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets end date as letters of week {string} and year {string}")
	public void theProjectLeaderSetsEndDateAsLettersOfWeekAndYear(String week, String year)
			throws Exception, OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setEndYear(projectID, year, devLeaderID);
			projectPlanner.setEndWeek(projectID, week, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader sets projectName to {string}")
	public void theProjectLeaderSetsProjectNameTo(String name) throws OperationNotAllowedException {
		try {
			projectPlanner.editProjectName(projectID, devLeaderID, name);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project has the name {string}")
	public void theProjectHasTheName(String name)
			throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		assertTrue(projectPlanner.getProjectName(projectID).equals(name));

	}

	@When("the project leader sets an invalid projectName of {string}")
	public void theProjectLeaderSetsAnInvalidProjectNameOf(String name) throws OperationNotAllowedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.editProjectName(projectID, devLeaderID, name);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the project leader requests project information")
	public void theProjectLeaderRequestsProjectInformation() throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
	   prjData = projectPlanner.getProjectInformation(projectID, devLeaderID);
	}
	
	@Given("the project has start year {string}, end year {string}, start week {string} and end week {string}")
	public void theProjectHasStartYearEndYearStartWeekAndEndWeek(String startYear, String endYear, String startWeek, String endWeek) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    projectPlanner.setStartYear(projectID, startYear, devLeaderID);
	    projectPlanner.setEndYear(projectID, endYear, devLeaderID);
	    projectPlanner.setStartWeek(projectID, startWeek, devLeaderID);
	    projectPlanner.setEndWeek(projectID, endWeek, devLeaderID);
	}

	@Then("the project leader has access to all the project information")
	public void theProjectLeaderHasAccessToAllTheProjectInformation() throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
	    prjData = projectPlanner.getProjectInformation(projectID, devLeaderID);
	    assertTrue(prjData.getStartYear() == project.getStartYear());
		assertTrue(prjData.getStartWeek() == project.getStartWeek());
		assertTrue(prjData.getEndYear() == project.getEndYear());
		assertTrue(prjData.getEndWeek() == project.getEndWeek());
		assertTrue(prjData.getProjectID().getName() == project.getName());
		assertTrue(prjData.getProjectID().getYear() != -1);
		assertTrue(prjData.getProjectID().getSerialNumber() != -1);
		assertTrue(prjData.getLeader().equals(devLeaderID));
	}

	// set activity date

	@When("the project leader sets activity start date of week {string} and year {string}")
	public void theProjectLeaderSetsActivityStartDateOfWeekAndYear(String week, String year)
			throws OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setActivityStartWeek(week, activityID, projectID, devLeaderID);
			projectPlanner.setActivityStartYear(year, activityID, projectID, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("then activity has start date of week {int} and year {int}")
	public void thenActivityHasStartDateOfWeekAndYear(int week, int year) throws NullObjectException {
		assertTrue(projectPlanner.getActivityStartWeek(activityID, projectID) == week);
		assertTrue(projectPlanner.getActivityStartYear(activityID, projectID) == year);
	}

	@Given("the project has an activity with end date of week {string} and year {string}")
	public void theProjectHasAnActivityWithEndDateOfWeekAndYear(String week, String year)
			throws NullObjectException, OperationNotAllowedException, FormattingException {
		projectPlanner.setActivityEndWeek(week, activityID, projectID, devLeaderID);
		projectPlanner.setActivityEndYear(year, activityID, projectID, devLeaderID);

	}

	@When("the project leader sets activity end date of week {string} and year {string}")
	public void theProjectLeaderSetsActivityEndDateOfWeekAndYear(String week, String year)
			throws OperationNotAllowedException, NullObjectException {
		try {
			projectPlanner.setActivityEndWeek(week, activityID, projectID, devLeaderID);
			projectPlanner.setActivityEndYear(year, activityID, projectID, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has end date of week {int} in year {int}")
	public void theActivityHasEndDateOfWeekInYear(Integer week, Integer year) throws NullObjectException {
		assertTrue(projectPlanner.getActivityEndWeek(activityID, projectID) == week);
		assertTrue(projectPlanner.getActivityEndYear(activityID, projectID) == year);
	}

	@Given("the project has an activity with start date of week {string} and year {string}")
	public void theProjectHasAnActivityWithStartDateOfWeekAndYear(String week, String year) throws OperationNotAllowedException, NullObjectException, FormattingException {
		projectPlanner.setActivityStartWeek(week, activityID, projectID, devLeaderID);
		projectPlanner.setActivityStartYear(year, activityID, projectID, devLeaderID);
	}
	
	//Get Incomplete Activities feature------------------------------------------------
	
	//Anders (s163952)
	@Given("there is registered {int} incomplete activity")
	public void thereIsRegisteredIncompleteActivity(Integer int1) 
			throws NullObjectException, OperationNotAllowedException {
	   for (int i = 0; i<int1.intValue(); i++) {
		   projectActivity = new Activity();
		   activityID = new ActivityID();
		   activityID.setName("Activity " + i);
		   projectActivity.setID(activityID);
		   projectPlanner.addProjectActivity(projectActivity, projectID, devLeader.getDeveloperID());
	   }
		
	}

	@When("the project leader requests a list of incomplete activities")
	public void theProjectLeaderRequestsAListOfIncompleteActivities() 
			throws OperationNotAllowedException, NullObjectException {
		try {
			incompleteActivities = projectPlanner.getIncompleteActivities(projectID, devLeaderID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project leader gets a list of incomplete activities with {int} activity")
	public void theProjectLeaderGetsAListOfIncompleteActivitiesWithActivity(Integer int1) {
		assertTrue (incompleteActivities.size() == int1);
	}
	
	@When("the developer tries to get a list of incomplete activities")
	public void theDeveloperTriesToGetAListOfIncompleteActivities()
		throws NullObjectException, OperationNotAllowedException {
			try {
				incompleteActivities = projectPlanner.getIncompleteActivities(projectID, testDeveloper.getDeveloperID());
			} catch (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
			}
	}
	
	@Given("there is registered {int} complete activities in the project")
	public void thereIsRegisteredCompleteActivitiesInTheProject(Integer int1) throws NullObjectException, OperationNotAllowedException {
		for (int i = 0; i<int1.intValue(); i++) {
			   projectActivity = new Activity();
			   activityID = new ActivityID();
			   activityID.setName("Activity " + i);
			   projectActivity.setID(activityID);
			   projectActivity.setActivityComplete();
			   projectPlanner.addProjectActivity(projectActivity, projectID, devLeaderID);
		   }
	}
	
	//Edit activity name feature------------------------------------------------
	
	//Anders (s163952)
	@When("the project leader sets activity name to {string}")
	public void theProjectLeaderSetsActivityNameTo(String name) 
			throws NullObjectException, FormattingException, OperationNotAllowedException {
		projectPlanner.setActivityName(activityID, projectID, name, devLeaderID);
	}
	
	@Then("the activity has the name {string}")
	public void theActivityHasTheName(String string) throws NullObjectException {
		activityID = new ActivityID();
		activityID.setName(string);
		assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}
	
	@When("the project leader sets an invalid activity name of {string}")
	public void theProjectLeaderSetsAnInvalidActivityNameOf(String string) 
			throws NullObjectException, FormattingException, OperationNotAllowedException {
		try {
			projectPlanner.setActivityName(activityID, projectID, string, devLeaderID);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
		
	}
	
	@When("the project leader sets the activity {string} name to {string}")
	public void theProjectLeaderSetsTheActivityNameTo(String name, String name2) 
			throws NullObjectException, FormattingException, OperationNotAllowedException {
	    ActivityID activityID = new ActivityID();
	    activityID.setName(name);
	    try {
			projectPlanner.setActivityName(activityID, projectID, name2, devLeaderID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	


	@Given("the developer with the id {string} has registered work hours {string} in week {string} and year {string} for the activity named {string}")
	public void theDeveloperWithTheIdHasRegisteredWorkHoursInWeekAndYearForTheActivityNamed(String id, String hours, String week, String year, String string5) throws NullObjectException, FormattingException {
		DeveloperID developerID = new DeveloperID();
	    developerID.setName(id);
	    projectPlanner.registerHours(week, year, hours, activityID, developerID, projectID);
	}

	@When("the project leader requests a list of available developer IDs in week {string} an year {string}")
	public void theProjectLeaderRequestsAListOfAvailableDeveloperIDsInWeekAnYear(String week, String year) throws FormattingException {	
		try {
			developerIDs = projectPlanner.getAvailableDevelopers(week, year);
		} catch (FormattingException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the project leader gets a list of available developers ID with {int} developerIDs")
	public void theProjectLeaderGetsAListOfAvailableDevelopersIDWithDeveloperIDs(Integer int1) {
	   assertTrue(developerIDs.size() == int1);
	}
	
	@When("an unregistered developer tries to assign a developer to the activity")
	public void anUnregisteredDeveloperTriesToAssignADeveloperToTheActivity() throws NullObjectException {
	    developerID = new DeveloperID();
	    developerID.setName("BadT");
	    try{
	    	projectPlanner.assignDeveloper(activityID, projectID, devLeaderID, developerID);
	    }catch(OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	@When("the user checks if a non registered developer is assigned to the activity")
	public void theUserChecksIfANonRegisteredDeveloperIsAssignedToTheActivity() throws NullObjectException {
	   developerID = new DeveloperID();
	   developerID.setName("BadT");
	   try{
		   projectPlanner.checkDeveloperAssigned(activityID, projectID, developerID);
	   }catch(OperationNotAllowedException e){
		   errorMessageHolder.setErrorMessage(e.getMessage());
	   }
	}
	
	@When("an unregistered developer tries to set expected work hours of the activity")
	public void anUnregisteredDeveloperTriesToSetExpectedWorkHoursOfTheActivity() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String hours = "20";
		try{
			projectPlanner.setExpectedHours(activityID, projectID, developerID, hours);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the activity as complete")
	public void anUnregisteredDeveloperTriesToSetTheActivityAsComplete() throws NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		try{
			projectPlanner.setActivityComplete(activityID, projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the project start year")
	public void anUnregisteredDeveloperTriesToSetTheProjectStartYear() throws Exception, FormattingException, NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String year = "2020";
		try{
			projectPlanner.setStartYear(projectID, year, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the project start week")
	public void anUnregisteredDeveloperTriesToSetTheProjectStartWeek() throws Exception, FormattingException, NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String week = "40";
		try{
			projectPlanner.setStartWeek(projectID, week, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the project end year")
	public void anUnregisteredDeveloperTriesToSetTheProjectEndYear() throws Exception, FormattingException, NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String year = "2021";
		try{
			projectPlanner.setEndYear(projectID, year, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the project end week")
	public void anUnregisteredDeveloperTriesToSetTheProjectEndWeek() throws Exception, FormattingException, NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String week = "40";
		try{
			projectPlanner.setEndWeek(projectID, week, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the project name")
	public void anUnregisteredDeveloperTriesToSetTheProjectName() throws FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String name = "FailingTest";
		try{
			projectPlanner.editProjectName(projectID, developerID, name);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to get a list of incomplete activities for the project")
	public void anUnregisteredDeveloperTriesToGetAListOfIncompleteActivitiesForTheProject() throws NullObjectException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		try{
			incompleteActivities = projectPlanner.getIncompleteActivities(projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the activity start year")
	public void anUnregisteredDeveloperTriesToSetTheActivityStartYear() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String year = "2020";
		try{
			projectPlanner.setActivityStartYear(year, activityID, projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("an unregistered developer tries to set the activity start week")
	public void anUnregisteredDeveloperTriesToSetTheActivityStartWeek() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String week = "40";
		try{
			projectPlanner.setActivityStartWeek(week, activityID, projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("an unregistered developer tries to set the activity end year")
	public void anUnregisteredDeveloperTriesToSetTheActivityEndYear() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String year = "2021";
		try{
			projectPlanner.setActivityEndYear(year, activityID, projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("an unregistered developer tries to set the activity end week")
	public void anUnregisteredDeveloperTriesToSetTheActivityEndWeek() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String week = "41";
		try{
			projectPlanner.setActivityEndWeek(week, activityID, projectID, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("an unregistered developer tries to set the activity name")
	public void anUnregisteredDeveloperTriesToSetTheActivityName() throws NullObjectException, FormattingException {
		developerID = new DeveloperID();
		developerID.setName("BadT");
		String name = "BadTest";
		try{
			projectPlanner.setActivityName(activityID, projectID, name, developerID);
		}catch(OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
}
