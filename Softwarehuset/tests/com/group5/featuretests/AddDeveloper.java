package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import com.group5.projectplanner.app.*;

public class AddDeveloper {
	ProjectPlanner projectPlanner;
	Developer developer;
	DeveloperID developerID;
	ErrorMessageHolder errorMessageHolder;
	DeveloperHelper developerHelper;

	public AddDeveloper(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, DeveloperHelper developerHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.developerHelper = developerHelper;
	}

	@Given("that a developer exists")
	public void thatADeveloperWithTheIDExists() throws Exception, FormattingException {
	    // Getting a developer and developerID instance from developer helper
		developer = developerHelper.exampleDeveloper();
	    developerID = developer.getDeveloperID();
	    // Checking if the ID in developer ID is equal to the id from the test
	    
	    // Checking if the developer is not null
	    assertTrue(developer!= null);	    
	}

	@When("the developer is added to the project planner")
	public void theDeveloperIsAddedToTheProjectPlanner() throws OperationNotAllowedException {
	    // Adds developer to the projectPlanner
		projectPlanner.addDeveloper(developer);
	}

	@Then("the developer is added to the project planner successfully")
	public void theDeveloperIsAddedToTheProjectPlannerSuccessfully() {
		// Checks if developer exist with the developerID from the added developer
	    assertTrue(projectPlanner.checkDeveloperExist(developerID));
	}
	
	@Given("that a developer is registered in the project planner")
	public void thatADeveloperWithTheIDIsRegisteredInTheProjectPlanner() throws Exception, FormattingException, OperationNotAllowedException {
	    // Makes sure that a developer with the ID "DevA" exist in project planner
		 // Getting a developer and developerID instance from developer helper
		developer = developerHelper.exampleDeveloper();
	    developerID = developer.getDeveloperID();
	    // Checking if the ID in developer ID is equal to the id from the test
	    projectPlanner.addDeveloper(developer); 
	    // Checks if the developer is in the project planner
	    assertTrue(projectPlanner.checkDeveloperExist(developerID));
	
	}

	@When("the developer is added again")
	public void theDeveloperIsAddedAgain() {
	    // Tries to add the developer
		try{
			projectPlanner.addDeveloper(developer);
		} catch (OperationNotAllowedException e){
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("he gets the error message {string}")
	public void heGetsTheErrorMessage(String error) {
	    // Checks if the errorMessageHolder gets the correct error message
		 assertTrue(errorMessageHolder.getErrorMessage().equals(error));
	}

	@Given("that a developer has the ID {string}")
	public void thatADeveloperHasTheID(String id) throws OperationNotAllowedException {
		developer = new Developer();
		developer.setName(id);
		DeveloperID developerID = new DeveloperID();
	    developerID.setName(id);
		assertTrue(developer.getName().equals(id));
		projectPlanner.addDeveloper(developer);
		assertTrue(projectPlanner.checkDeveloperExist(developer.getDeveloperID()));
	}
	



}