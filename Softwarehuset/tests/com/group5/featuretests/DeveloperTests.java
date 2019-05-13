package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertFalse;
import com.group5.projectplanner.app.*;

public class DeveloperTests {
	ProjectPlanner projectPlanner;
	Developer developer;
	Activity projectActivity;
	Project project;
	Project project2; 
	ProjectID projectID;
	ProjectID projectID2; 
	DeveloperID developerID;
	DeveloperID testDeveloperID;
	Developer testDeveloper;
	List<ProjectID> projectIDs;
	ActivityID activityID;
	List<ActivityID> activityIDs;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	DeveloperHelper developerHelper;
	ActivityData activityData;
	ActivityHelper activityHelper;
	DeveloperID devLeaderID;
	Developer devLeader;

	public DeveloperTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, 
			ProjectHelper projectHelper, DeveloperHelper developerHelper, ActivityHelper activityHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.projectHelper = projectHelper;
		this.developerHelper = developerHelper;
		this.activityHelper = activityHelper;
	}

	//Add Developer:-----------------------------------------------
	//Author: Casper (s163950)
	@Given("that a developer with the ID {string} exists")
	public void thatADeveloperWithTheIDExists(String id)throws NullObjectException {
	    developer = new Developer();
	    developer.setName(id);
	    developerID = new DeveloperID();
	    developerID.setName(developer.getName());
	    assertTrue(developer.getName().equals(id));
	    assertTrue(developer.getDeveloperID()!= null);
	}

	//Author: Casper (s163950)
	@When("the developer is added to the project planner")
	public void theDeveloperIsAddedToTheProjectPlanner() throws OperationNotAllowedException, NullObjectException {
	    	projectPlanner.addDeveloper(developer);
	}

	//Author: Casper (s163950)
	@Then("the developer is added to the project planner successfully")
	public void theDeveloperIsAddedToTheProjectPlannerSuccessfully() {
	    assertTrue(projectPlanner.checkDeveloperExist(developer.getDeveloperID()));
	}//////////// check her
	
	//Author: Casper (s163950)
	@Given("the developer is registered in the project planner")
	public void theDeveloperIsRegisteredInTheProjectPlanner() throws OperationNotAllowedException{
	    projectPlanner.addDeveloper(developer);
	}
	
	//Author: Casper (s163950)
	@When("the developer is added again")
	public void theDeveloperIsAddedAgain() throws OperationNotAllowedException{
		try{
			projectPlanner.addDeveloper(developer);
		} catch (OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	//Author: Casper (s163950)
	@Given("that a developer is registered in the project planner")
	public void thatADeveloperIsRegisteredInTheProjectPlanner() throws OperationNotAllowedException, Exception, FormattingException {
		developer = developerHelper.getDeveloper();
		assertTrue(developer.getName().equals("abcd"));
		projectPlanner.addDeveloper(developer);
		developerID = developer.getDeveloperID();
		assertTrue(projectPlanner.checkDeveloperExist(developerID));
	}

	//Author: Casper (s163950)
	@When("the developer adds a project with the name {string} and start year of {string}")
	public void theDeveloperAddsAProjectWithTheNameAndStartYearOf(String name, String year) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		project = new Project();
		projectID = new ProjectID(name);
		project.setID(projectID);
	    try{
	    	project.setStartYear(year);
	    	try{
		    	projectPlanner.addProject(project, developerID);
		    }catch (OperationNotAllowedException e){
		    	errorMessageHolder.setErrorMessage(e.getMessage());
		    }
	    }catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	    
	}
	
	@When("the developer adds another project with the name {string} and start year of {string}")
	public void theDeveloperAddsAnotherProjectWithTheNameAndStartYearOf(String name, String year) throws Exception, NullObjectException {
		project2 = new Project();
		projectID2 = new ProjectID(name);
		project2.setID(projectID2);
	    try{
	    	project2.setStartYear(year);
	    	try{
		    	projectPlanner.addProject(project2, developerID);
		    }catch (OperationNotAllowedException e){
		    	errorMessageHolder.setErrorMessage(e.getMessage());
		    }
	    }catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	@Then("the projects are added to the project planner")
	public void theProjectsAreAddedToTheProjectPlanner() {
		assertTrue(project.getName().equals("Robot Software"));
		assertTrue(project.getStartYear()== 2020);
		assertTrue(projectPlanner.checkProjectExist(projectID));
		assertTrue(project2.getName().equals("Robot Software II"));
		assertTrue(project2.getStartYear()== 2020);
		assertTrue(projectPlanner.checkProjectExist(projectID2));
	}
		
	//Author: Casper (s163950)
	@Then("the project with the name {string} and start year of {int} is added to the project planner")
	public void theProjectWithTheNameAndStartYearOfIsAddedToTheProjectPlanner(String name, int year) {
	    assertTrue(project.getName().equals(name));
		assertTrue(project.getStartYear()==year);
		
		assertTrue(projectPlanner.checkProjectExist(projectID));
	}

	//Author: Casper (s163950)
	@Then("he gets the error message {string}")
	public void heGetsTheErrorMessage(String error) {
	    assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}

	//Author: Casper (s163950)
	@Given("a project is registered with the name {string}")
	public void aProjectIsRegisteredWithTheName(String name) throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		project = new Project();
		projectID = new ProjectID(name);
		project.setID(projectID);
	    project.setStartYear("2020");
	    projectPlanner.addProject(project, developerID);
	    projectPlanner.checkProjectExist(projectID);
	}

	//Author: Casper (s163950)
	@Given("that a developer is not registered in the project planner")
	public void thatADeveloperIsNotRegisteredInTheProjectPlanner() {
	    developer = new Developer();
	    developer.setName("abcd");
	}

	//SetProjectLeader:------------------------
	//Author: Casper (s163950)
	@Given("a developer with ID {string} is registered in the project planner")
	public void aDeveloperWithIDIsRegisteredInTheProjectPlanner(String id) throws OperationNotAllowedException{
		developer = new Developer();
		developer.setName(id);
		DeveloperID developerID = new DeveloperID();
	    developerID.setName(id);
		assertTrue(developer.getName().equals(id));
		projectPlanner.addDeveloper(developer);
		assertTrue(projectPlanner.checkDeveloperExist(developer.getDeveloperID()));
		return;
	}
	
	//Author: Casper (s163950)
	@Given("a project is registered in the project planner")
	public void aProjectIsRegisteredInTheProjectPlanner() throws Exception, FormattingException, OperationNotAllowedException, NullObjectException {
		project = projectHelper.getProject();
		projectID = project.getID();
		
	    projectPlanner.addProject(project, developer.getDeveloperID());
	    assertTrue(projectPlanner.checkProjectExist(projectID));
	}
	
	//Author: Casper (s163950)
	@Then("the project has project leader with ID {string}")
	public void theProjectHasProjectLeaderWithID(String string) throws Exception, FormattingException {
	    assertTrue(projectPlanner.isProjectLeader(projectID, developer.getDeveloperID()));
	}
	
	//Author: Casper (s163950)
	@When("the developer sets developer with ID {string} as project leader in the project")
	public void theDeveloperSetsDeveloperWithIDAsProjectLeaderInTheProject(String badID) throws Exception, FormattingException, NullObjectException {
	    Developer badDeveloper = new Developer();
	    badDeveloper.setName(badID);
	    try{
	    	projectPlanner.setProjectLeader(projectID, badDeveloper.getDeveloperID());
	    } catch (OperationNotAllowedException | NullObjectException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}

	@When("the developer registers work hours {string} in week {string} and year {string} for the activity named {string}")
	public void theDeveloperRegistersWorkHoursInWeekAndYearForTheActivityNamed(String hours, String week, String year, String name) throws NullObjectException, FormattingException {
	    // Write code here that turns the phrase above into concrete actions
		ActivityID testActivityID = new ActivityID();
		testActivityID.setName(name);
		DeveloperID developerID = developer.getDeveloperID();
		try{
			 projectPlanner.registerHours(week, year, hours, testActivityID, developerID, projectID);
	    } catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	   
	}

	@Then("the developer has registered work hours {double} in week {int} and year {int} for the activity named {string}")
	public void theDeveloperHasRegisteredWorkHoursInWeekAndYearForTheActivityNamed(Double hours, Integer week, Integer year, String string) throws NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		DeveloperID developerID = developer.getDeveloperID();
	
		assertTrue(projectPlanner.getHours(week, year, developerID) == hours);
	}
	
//Remove developer feature
	
	@When("the developer is removed from the project planner")
	public void theDeveloperIsRemovedFromTheProjectPlanner() throws OperationNotAllowedException {
		try{
			projectPlanner.removeDeveloper(developerID);
		} catch (OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the developer is removed from the project planner successfully")
	public void theDeveloperIsRemovedFromTheProjectPlannerSuccessfully() {
		assertTrue(!projectPlanner.checkDeveloperExist(developer.getDeveloperID()));

	}
	
	@Given("that a developer with the ID {string} is not registered in project planner")
	public void thatADeveloperWithTheIDIsNotRegisteredInProjectPlanner(String id) {
		 developer = new Developer();
		 developer.setName(id);
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
	}
	
// Checks if Dev attempts project leader actions
	
	@When("a developer assigns a developer to the activity")
	public void aDeveloperAssignsADeveloperToTheActivity() throws OperationNotAllowedException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 projectPlanner.assignDeveloper(activityID, projectID, developerID, testDeveloperID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}
	

	@When("a developer sets expected work hours to {string}")
	public void aDeveloperSetsExpectedWorkHoursTo(String hours) throws NullObjectException, FormattingException, OperationNotAllowedException {
		// Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 projectPlanner.setExpectedHours(activityID, projectID, developerID, hours);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	
	}
	

	@When("a developer sets the activity as complete")
	public void aDeveloperSetsTheActivityAsComplete() throws OperationNotAllowedException, NullObjectException {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 projectPlanner.setActivityComplete(activityID, projectID, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}
	
	@When("a developers sets activity start year {string}")
	public void aDevelopersSetsActivityStartYear(String year) throws NullObjectException, FormattingException, OperationNotAllowedException {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 	projectPlanner.setActivityStartYear(year, activityID, projectID, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}

	@When("a developers sets activity end year {string}")
	public void aDevelopersSetsActivityEndYear(String year) throws NullObjectException, FormattingException, OperationNotAllowedException {
	    // Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 	projectPlanner.setActivityEndYear(year, activityID, projectID, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}

	@When("a developers sets activity start week of {string}")
	public void aDevelopersSetsActivityStartWeekOf(String week) throws NullObjectException, FormattingException, OperationNotAllowedException {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 	projectPlanner.setActivityStartWeek(week, activityID, projectID, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}

	@When("a developers sets activity end week of {string}")
	public void aDevelopersSetsActivityEndWeekOf(String week) throws OperationNotAllowedException, NullObjectException, FormattingException {
	    // Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 	projectPlanner.setActivityEndWeek(week, activityID, projectID, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}
	
	@When("a developer sets activity name to {string}")
	public void aDeveloperSetsActivityNameTo(String name) throws NullObjectException, FormattingException, OperationNotAllowedException {
	    // Write code here that turns the phrase above into concrete actions
		 developer = new Developer();
		 developer.setName("bcde");
		 developerID = new DeveloperID();
		 developerID.setName(developer.getName());
		 projectPlanner.addDeveloper(developer);
		 testDeveloper = new Developer();
		 testDeveloper.setName("test");
		 testDeveloperID = testDeveloper.getDeveloperID();
		 projectPlanner.addDeveloper(testDeveloper);
		 System.out.println(activityID);
		 activityID = new ActivityID();
		 activityID.setName("ActivityTest");
		 projectID = new ProjectID();
		 projectID.setName("Test");
		 try {
			 	projectPlanner.setActivityName(activityID, projectID, name, developerID);
		 }catch  (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
		 };
	}
	
	
	
	@When("the developer sets projectName to {string}")
	public void theDeveloperSetsProjectNameTo(String name) throws OperationNotAllowedException, FormattingException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.editProjectName(projectID, developerID, name);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the developer sets start date of week {string} and year {string}")
	public void theDeveloperSetsStartDateOfWeekAndYear(String week, String year) throws Exception, FormattingException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.setStartWeek(projectID, week, developerID);
			projectPlanner.setStartYear(projectID, year, developerID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		};
	}
	
	@When("the developer sets end date of week {string} and year {string}")
	public void theDeveloperSetsEndDateOfWeekAndYear(String week, String year) throws Exception, FormattingException, NullObjectException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			projectPlanner.setEndWeek(projectID, week, developerID);
			projectPlanner.setEndYear(projectID, year, developerID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		};
	}

	
	
	//Get Activity Information feature
	
	@Given("the project has an activity registered")
	public void theProjectHasAnActivityRegistered() 
			throws NullObjectException, OperationNotAllowedException, FormattingException, Exception {
		projectActivity = activityHelper.getActivity();
		activityID = projectActivity.getID();
		devLeaderID = new DeveloperID();
		devLeaderID.setName("LEAD");
		Developer devLeader = new Developer();
		devLeader.setName("LEAD");
		projectPlanner.addDeveloper(devLeader);
		projectPlanner.setProjectLeader(projectID, devLeaderID);
		projectPlanner.addProjectActivity(projectActivity, projectID, devLeaderID);
	    assertTrue(projectPlanner.checkActivityExists(activityID, projectID));
	}

	@When("the developer requests activity information")
	public void theDeveloperRequestsActivityInformation() 
			throws NullObjectException {
		activityData = projectPlanner.getActivityInformation(projectID, activityID,developerID);
	}

	
	@Then("the developer has access to the activity information")
	public void theDeveloperHasAccessToTheActivityInformation() {
		assertTrue(activityData != null);
		assertTrue(activityData.getStartYear() == projectActivity.getActivityStartYear());
	}
	
	@Given("the activity has start year {string}, end year {string}, start week {string} and end week {string}")
	public void theActivityHasStartYearEndYearStartWeekAndEndWeek
	(String startYear, String endYear, String startWeek, String endWeek) 
			throws OperationNotAllowedException, NullObjectException, FormattingException {
		projectPlanner.setActivityStartYear(startYear, activityID, projectID, devLeaderID);
	    projectPlanner.setActivityEndYear(endYear, activityID, projectID, devLeaderID);
	    projectPlanner.setActivityStartWeek(startWeek, activityID, projectID, devLeaderID);
	    projectPlanner.setActivityEndWeek(endWeek, activityID, projectID, devLeaderID);
	}
	
	@Given("the activity has total expected hours {string}")
	public void theActivityHasTotalExpectedHoursAndItIsIncomplete (String totalExpectedHours) 
			throws OperationNotAllowedException, NullObjectException, FormattingException {
		projectPlanner.setExpectedHours(activityID, projectID, devLeaderID, totalExpectedHours);
	}
	
	@Given("the activity is complete")
	public void theActivityIsComplete() throws OperationNotAllowedException, NullObjectException {
		projectPlanner.setActivityComplete(activityID, projectID, devLeaderID);
	}
	
	@Given("the developer is registered in the activity")
	public void theDeveloperIsRegisteredInTheActivity() 
			throws NullObjectException, OperationNotAllowedException {
		projectPlanner.assignDeveloper(activityID, projectID, devLeaderID, developerID);
	}
	
	@Then("the developer has access to all the activity information")
	public void theDeveloperHasAccessToAllTheActivityInformation() throws NullObjectException {
		activityData = projectPlanner.getActivityInformation(projectID, activityID,developerID);
		assertTrue(activityData.getID() == projectActivity.getID());
		assertTrue(activityData.getDevelopers() == projectActivity.getDevelopers());
		assertTrue(activityData.getExpectedWorkHours() == projectActivity.getExpectedWorkHours());
		assertTrue(activityData.getCompleteness() == projectActivity.isActivityComplete());
		assertTrue(activityData.getStartYear() == projectActivity.getActivityStartYear());
		assertTrue(activityData.getStartWeek() == projectActivity.getActivityStartWeek());
		assertTrue(activityData.getEndYear() == projectActivity.getActivityEndYear());
		assertTrue(activityData.getEndWeek() == projectActivity.getActivityEndWeek());	
	}
	
	@Given("{int} project is registered in the project planner")
	public void projectIsRegisteredInTheProjectPlanner(Integer count) throws Exception, FormattingException, NullObjectException, OperationNotAllowedException {
	    
	    for(int i = 0; i < count; i++){
	    	project = new Project();
		    project.setStartYear("2020");
		    projectID = new ProjectID();
	    	String name= "Test"+i;
	    	projectID.setName(name);
	    	project.setID(projectID);
	    	projectPlanner.addProject(project, developerID);
	    }
	}

	@When("the developer requests a list of project IDs")
	public void theDeveloperRequestsAListOfProjectIDs() {
		projectIDs = projectPlanner.getProjectIDs();
	}
	
	@Then("the developer has access to a list of {int} project IDs")
	public void theDeveloperHasAccessToAListOfProjectIDs(Integer count) {
	    assertTrue(projectIDs != null);
	    assertTrue(projectIDs.size() == count);
	}

	@Given("{int} activity is registered on the project")
	public void activityIsRegisteredOnTheProject(Integer count) throws OperationNotAllowedException, Exception, FormattingException, NullObjectException {
		Developer devLeader = new Developer();
		devLeaderID = new DeveloperID();
		devLeaderID.setName("Test2");
		devLeader.setID(devLeaderID);
		projectPlanner.addDeveloper(devLeader);
		projectPlanner.setProjectLeader(projectID, devLeaderID);
		for(int i = 0; i < count; i++){
	    	Activity activity = new Activity();
		    ActivityID activityID = new ActivityID();
		    String name = "Test"+i;
		    activityID.setName(name);
	    	activity.setID(activityID);
	    	projectPlanner.addProjectActivity(activity, projectID, devLeaderID);
	    }
	}
	
	@When("the developer requests a list of activity IDs")
	public void theDeveloperRequestsAListOfActivityIDs() throws NullObjectException {
	    activityIDs = projectPlanner.getActivityIDs(projectID, developerID);
	}
	
	@Then("the developer has access to a list of {int} activity IDs")
	public void theDeveloperHasAccessToAListOfActivityIDs(Integer count) {
	    assertTrue(activityIDs != null);
	    assertTrue(activityIDs.size() == count);
	}
}
