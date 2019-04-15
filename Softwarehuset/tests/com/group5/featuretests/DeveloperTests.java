package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.group5.projectplanner.app.*;

public class DeveloperTests {
	ProjectPlanner projectPlanner;
	Developer developer;
	Project project;
	ErrorMessageHolder errorMessageHolder;

	public DeveloperTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
	}

	//CreateProject
	@Given("that a developer is registered in the project planner")
	public void thatADeveloperIsRegisteredInTheProjectPlanner() {
		developer = new Developer();
		developer.setID("abcd");
		assertTrue(developer.getID().equals("abcd"));
		projectPlanner.addDeveloper(developer);
		assertTrue(projectPlanner.checkDeveloperExist(developer));
		return;
	}

	@When("the developer adds a project with the name {string} and start year of {string}")
	public void theDeveloperAddsAProjectWithTheNameAndStartYearOf(String name, String year) throws Exception, FormattingException, OperationNotAllowedException {
		project = new Project();
	    project.setName(name);
	    try{
	    	project.setStartYear(year);
	    }catch (FormattingException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	    try{
	    	projectPlanner.addProject(project, developer);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	
	@Then("the project with the name {string} and start year of {int} is added to the project planner")
	public void theProjectWithTheNameAndStartYearOfIsAddedToTheProjectPlanner(String name, int year) {
	    assertTrue(project.getName().equals(name));
		assertTrue(project.getStartYear()==year);
		assertTrue(projectPlanner.checkProjectExist(project));
	}

	@Then("he gets the error message {string}")
	public void heGetsTheErrorMessage(String error) {
	    assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}

	@Given("a project is registered with the name {string}")
	public void aProjectIsRegisteredWithTheName(String name) throws Exception, FormattingException, OperationNotAllowedException {
		project = new Project();
	    project.setName(name);
	    project.setStartYear("2020");
	    projectPlanner.addProject(project, developer);
	}

	@Given("that a developer is not registered in the project planner")
	public void thatADeveloperIsNotRegisteredInTheProjectPlanner() {
	    developer = new Developer();
	    developer.setID("abcd");
	}
	
	//SetProjectLeader
	
	@Given("a developer with ID {string} is registered in the project planner")
	public void aDeveloperWithIDIsRegisteredInTheProjectPlanner(String id) {
		developer = new Developer();
		developer.setID(id);
		assertTrue(developer.getID().equals(id));
		projectPlanner.addDeveloper(developer);
		assertTrue(projectPlanner.checkDeveloperExist(developer));
		return;
	}
	
	@Given("a project is registered in the project planner")
	public void aProjectIsRegisteredInTheProjectPlanner() throws Exception, FormattingException {
	    project = new Project();
	    project.setName("Test");
	    project.setStartYear("2020");
	    projectPlanner.addProject(project, developer);
	    assertTrue(projectPlanner.checkProjectExist(project));
	}

	@When("the developer sets himself as project leader on the project")
	public void theDeveloperSetsHimselfAsProjectLeaderOnTheProject() throws OperationNotAllowedException, Exception, FormattingException {
	    projectPlanner.setProjectLeader(project, developer);
	}

	@Then("the project has project leader with ID {string}")
	public void theProjectHasProjectLeaderWithID(String string) throws Exception, FormattingException {
	    assertTrue(projectPlanner.isProjectLeader(project, developer));
	}
	
	@When("the developer sets developer with ID {string} as project leader in the project")
	public void theDeveloperSetsDeveloperWithIDAsProjectLeaderInTheProject(String badID) throws Exception, FormattingException {
	    Developer badDeveloper = new Developer();
	    badDeveloper.setID(badID);
	    try{
	    	projectPlanner.setProjectLeader(project, badDeveloper);
	    } catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	
}
