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
	List<ProjectID> projectIDs;
	ActivityID activityID;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	DeveloperHelper developerHelper;

	public DeveloperTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, ProjectHelper projectHelper, DeveloperHelper developerHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.projectHelper = projectHelper;
		this.developerHelper = developerHelper;
	}

	//Add Developer:-----------------------------------------------
	//Author: Casper (s163950)
	@Given("that a developer with the ID {string} exists")
	public void thatADeveloperWithTheIDExists(String id)throws NullObjectException {
	    developer = new Developer();
	    developer.setName(id);
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
			projectPlanner.removeDeveloper(developer);
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
	}

	@When("the developer is removed")
	public void theDeveloperIsRemoved() {
	    // Write code here that turns the phrase above into concrete actions
		try{
			projectPlanner.removeDeveloper(developer);
		} catch (OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	




}
