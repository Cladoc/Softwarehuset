package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import com.group5.projectplanner.app.*;

public class ProjectTests {
	ProjectPlanner projectPlanner;
	Developer developer;
	DeveloperID developerID;
	Project project;
	ProjectID projectID;
	ErrorMessageHolder errorMessageHolder;
	DeveloperHelper developerHelper;
	ProjectHelper projectHelper;

	public ProjectTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, DeveloperHelper developerHelper, ProjectHelper projectHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.developerHelper = developerHelper;
		this.projectHelper = projectHelper;
	}
	
	@Given("a project exists")
	public void aProjectExists() throws Exception, FormattingException, NullObjectException {
	    project = projectHelper.exampleProject();
	    projectID = project.getID();
	    assertTrue(project!=null);
	}

	@When("the developer adds a project to the project planner")
	public void theDeveloperAddsAProjectToTheProjectPlanner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the project is added to the project planner")
	public void theProjectIsAddedToTheProjectPlanner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}